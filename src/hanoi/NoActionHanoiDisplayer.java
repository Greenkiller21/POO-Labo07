package hanoi;

/**
 * Classe n'effectuant rien lors de l'affichage d'un état de Hanoi (utilisé
 * pour les tests unitaires)
 */
public class NoActionHanoiDisplayer extends HanoiDisplayer {
    /**
     * Ne fait rien du tout
     * @param h La tour de Hanoi
     */
    @Override
    public void display(Hanoi h) { }
}
