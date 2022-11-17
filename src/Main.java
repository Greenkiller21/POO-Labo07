import hanoi.Hanoi;
import hanoi.gui.JHanoi;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            new JHanoi();
        }
        if (args.length == 1) {
            int nbDisk;
            try {
                nbDisk = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Le nombre entré n'est pas valide !");
            }

            if (nbDisk <= 0) {
                throw new RuntimeException("Le nombre de disques n'est pas valide !");
            }

            Hanoi h = new Hanoi(nbDisk);
            h.solve();
        }
    }
}