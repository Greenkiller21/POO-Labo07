import hanoi.CmdHanoiDisplayer;
import hanoi.Hanoi;
import hanoi.HanoiDisplayer;
import hanoi.gui.JHanoi;

public class Main {
    public static void main(String[] args) {
        Hanoi h = new Hanoi(3, new CmdHanoiDisplayer());
        h.solve();

        JHanoi h2 = new JHanoi();
    }
}