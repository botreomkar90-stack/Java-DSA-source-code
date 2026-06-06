class ManualStack {
    int[] arr;
    int top;
    int capacity;

    
    ManualStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    
    void push(int val) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Can't push " + val);
            return;
        }
        arr[++top] = val;
        System.out.println(val + " pushed");
    }

    
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Nothing to pop");
            return -1;
        }
        return arr[top--];
    }

    
    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    
    boolean isEmpty() {
        return top == -1;
    }

    int size() {
        return top + 1;
    }
}

public class Main{
    public static void main(String[] args) {
        ManualStack s = new ManualStack(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Top element: " + s.peek());   
        System.out.println("Popped: " + s.pop());         
        System.out.println("Popped: " + s.pop());         
        System.out.println("Top now: " + s.peek());       
        System.out.println("Size: " + s.size());          
    }
}