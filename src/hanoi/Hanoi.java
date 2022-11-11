package hanoi;

import util.Stack;
import util.StackIterator;

public class Hanoi {
    private int disks;
    private HanoiDisplayer displayer;
    private int turn;
    private boolean finished;

    private final Stack<Integer>[] status = new Stack[] {
            new Stack<Integer>(),
            new Stack<Integer>(),
            new Stack<Integer>()
    };

    /**
     * Affiche l’état des aiguilles de l’instance de la classe Hanoi.
     * Par défaut l’affichage se fait à la console
     * @param disks     Le nombre de disques
     * @param displayer L'objet pour afficher la tour de Hanoi
     */
    public Hanoi(int disks, HanoiDisplayer displayer) {
        this.disks = disks;
        this.displayer = displayer;
        this.turn = 0;
        this.finished = false;

        for (int i = disks; i > 0; --i) {
            this.status[0].push(i);
        }


    }

    public Hanoi(int disks) {
        this(disks, new CmdHanoiDisplayer());
    }

    public void solve() {
        displayer.display(this);
        towerOfHanoi(disks, 0, 2, 1);
    }

    public int[][] status() {
        int[][] status = new int[this.status.length][];
        for (int i = 0; i < this.status.length; ++i) {
            Object[] arr = this.status[i].toArray();
            int[] intArr = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                intArr[j] = (Integer)arr[j];
            }
            status[i] = intArr;
        }

        return status;
    }

    public boolean finished() {
        return finished;
    }

    public int turn() {
        return turn;
    }

    /**
     * Adapted from : https://www.digitalocean.com/community/tutorials/tower-of-hanoi
     * @param currentDisk
     * @param rodFrom
     * @param rodTo
     * @param rodAux
     */
    private void towerOfHanoi(int currentDisk,
                              int rodFrom,
                              int rodTo,
                              int rodAux) {
        if (currentDisk == 1) {
            move(rodFrom, rodTo);
            if (!status[0].iterator().hasNext() &&
                !status[1].iterator().hasNext()) {
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

    private void move(int rodFrom, int rodTo) {
        if (!isRodValid(rodFrom) || !isRodValid(rodTo)) {
            throw new RuntimeException("The rod selected is not valid !");
        }

        ++turn;

        Integer disk = status[rodFrom].pop();
        status[rodTo].push(disk);
    }

    private boolean isRodValid(int rod) {
        return rod >= 0 && rod < status.length;
    }

    @Override
    public String toString() {
        return "-- Turn: " + turn()    + '\n' +
               "One:   "   + status[0] + '\n' +
               "Two:   "   + status[1] + '\n' +
               "Three: "   + status[2];
    }
}
