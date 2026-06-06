import java.util.Stack;

public class BuiltIn{
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top: " + s.peek());    // 30
        System.out.println("Pop: " + s.pop());     // 30
        System.out.println("Pop: " + s.pop());     // 20
        System.out.println("Empty? " + s.isEmpty()); // false
    }
}