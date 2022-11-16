package hanoi;

import util.Stack;

public class Hanoi {
    /**
     * Le nombre de disques pour lequel résoudre le problème
     */
    private final int disks;

    /**
     * L'object à utiliser pour afficher la tour de Hanoi
     */
    private final HanoiDisplayer displayer;

    /**
     * Stock le nombre de disques déplacés
     */
    private int turn;

    /**
     * Indique si l'on a trouvé ou non la solution
     */
    private boolean finished;

    /**
     * Le status actuel des aiguilles
     */
    private final Stack<Integer>[] rods = new Stack[] {
            new Stack<Integer>(),
            new Stack<Integer>(),
            new Stack<Integer>()
    };

    /**
     * Résout le problème des tours de Hanoi avec n disques
     * @param disks     Le nombre de disques
     * @param displayer L'objet pour afficher la tour de Hanoi
     */
    public Hanoi(int disks, HanoiDisplayer displayer) {
        this.disks = disks;
        this.displayer = displayer;
        this.turn = 0;
        this.finished = false;

        for (int i = disks; i > 0; --i) {
            this.rods[0].push(i);
        }
    }

    /**
     * Résout le problème des tours de Hanoi avec n disques et utilise la
     * console comme affichage
     * @param disks Le nombre de disques
     */
    public Hanoi(int disks) {
        this(disks, new CmdHanoiDisplayer());
    }

    /**
     * Résoud le problème en affichant à chaque fois qu'un disque est déplacé
     */
    public void solve() {
        displayer.display(this);
        towerOfHanoi(disks, 0, 2, 1);
    }

    /**
     * Retourne le status actuel de chaque aiguille
     * @return Le status actuel de chaque aiguille
     */
    public int[][] status() {
        int[][] status = new int[this.rods.length][];
        for (int i = 0; i < this.rods.length; ++i) {
            Object[] arr = this.rods[i].toArray();
            int[] intArr = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                intArr[j] = (Integer)arr[j];
            }
            status[i] = intArr;
        }

        return status;
    }

    /**
     * Retourne si l'on a trouvé la solution ou non à ce moment
     * @return Si l'on a trouvé la solution
     */
    public boolean finished() {
        return finished;
    }

    /**
     * Retourne le nombre de disques déplacés au total
     * @return Le nombre de disques déplacés au total
     */
    public int turn() {
        return turn;
    }

    /**
     * Adapted from : https://www.digitalocean.com/community/tutorials/tower-of-hanoi
     * @param currentDisk Le disque actuel (taille et non l'index)
     * @param rodFrom     L'aiguille de laquelle l'on veut enlever le disque
     * @param rodTo       L'aiguille à laquelle l'on veut mettre le disque
     * @param rodAux      L'aiguille restante
     */
    private void towerOfHanoi(int currentDisk,
                              int rodFrom,
                              int rodTo,
                              int rodAux) {
        if (currentDisk == 1) {
            move(rodFrom, rodTo);
            //Si les deux premières aiguilles sont vides, alors on a fini
            if (!rods[0].iterator().hasNext() &&
                !rods[1].iterator().hasNext()) {
                finished = true;
            }
            displayer.display(this);
            return;
        }

        towerOfHanoi(currentDisk - 1, rodFrom, rodAux, rodTo);
        move(rodFrom, rodTo);
        displayer.display(this);
        towerOfHanoi(currentDisk - 1, rodAux, rodTo, rodFrom);
    }

    /**
     * Bouge un disque l'un aiguille à une autre
     * On ne regarde pas si le mouvement est légal (poser un disque de taille
     * 2 sur un disque de taille 1)
     * @param rodFrom L'aiguille de laquelle l'on veut prendre le disque
     * @param rodTo   L'aiguille à laquelle l'on veut mettre le disque
     */
    private void move(int rodFrom, int rodTo) {
        if (!isRodValid(rodFrom) || !isRodValid(rodTo)) {
            throw new RuntimeException("The rod selected is not valid !");
        }

        //Déplacement du disque
        Integer disk = rods[rodFrom].pop();
        rods[rodTo].push(disk);

        //Un disque à été déplacé
        ++turn;
    }

    /**
     * Retourne si l'aiguille choisie existe ou non
     * @param rod L'aiguille à contrôler
     * @return
     */
    private boolean isRodValid(int rod) {
        return rod >= 0 && rod < rods.length;
    }

    /**
     * Affiche l'état actuel de la tour de Hanoi
     * @return L'état actuel de la tour de Hanoi
     */
    @Override
    public String toString() {
        return "-- Turn: " + turn()    + '\n' +
               "One:   "   + rods[0] + '\n' +
               "Two:   "   + rods[1] + '\n' +
               "Three: "   + rods[2];
    }
}
