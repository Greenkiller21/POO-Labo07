import hanoi.Hanoi;
import hanoi.gui.JHanoi;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            new JHanoi();
        }
        else if (args.length == 1) {
            int nbDisk = -1;
            try {
                nbDisk = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Le nombre entré n'est pas valide !");
                System.exit(1);
            }

            if (nbDisk <= 0) {
                System.err.println("Le nombre de disques n'est pas valide !");
                System.exit(1);
            }

            Hanoi h = new Hanoi(nbDisk);
            h.solve();
        } else {
            System.err.println("Le nombre de paramètres n'est pas correct !");
            System.exit(1);
        }
    }
}