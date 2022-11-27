package hanoi;

/**
 * Classe permettant d'afficher dans la console un état de la tour de Hanoi
 */
public class CmdHanoiDisplayer extends HanoiDisplayer {
    /**
     * Affiche l'état actuel de la tour de Hanoi
     * @param h La tour de Hanoi à afficher
     */
    @Override
    public void display(Hanoi h) {
        System.out.println(h);
    }
}
