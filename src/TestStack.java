import util.*;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("0");
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        System.out.println("Stack après 5 insertions :");
        System.out.println(stack);
        System.out.println();

        Object[] s = stack.toArray();

        System.out.println(stack.pop() + " supprimé");
        stack.push("5");
        System.out.println(stack.pop() + " supprimé");
        stack.push("6");
        System.out.println("6 inséré");
        System.out.println();

        System.out.println("Stack mise a jour :");
        System.out.println(stack);
        System.out.println();

        System.out.println(stack.pop() + " supprimé");
        System.out.println(stack.pop() + " supprimé");
        System.out.println();

        System.out.println("Stack mise a jour :");
        System.out.println(stack);
        System.out.println();

        System.out.println("La stack du tableau :");
        for (Object o : s) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
