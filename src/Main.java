public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("0");
        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);
    }
}