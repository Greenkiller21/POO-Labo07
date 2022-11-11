package hanoi;

public class CmdHanoiDisplayer extends HanoiDisplayer {
    @Override
    public void display(Hanoi h) {
        System.out.println(h);
    }
}
