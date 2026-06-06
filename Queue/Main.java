class ManualQueue {
    int[] arr;
    int front, rear, size, capacity;

    
    ManualQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    
    void enqueue(int val) {
        if (size == capacity) {
            System.out.println("Queue Full! Can't add " + val);
            return;
        }
        rear = (rear + 1) % capacity; 
        arr[rear] = val;
        size++;
        System.out.println(val + " enqueued");
    }

    
    int dequeue() {
        if (size == 0) {
            System.out.println("Queue Empty!");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity; 
        size--;
        return val;
    }

    
    int peek() {
        if (size == 0) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return arr[front];
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        ManualQueue q = new ManualQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Front: " + q.peek());   
        System.out.println("Dequeued: " + q.dequeue()); 
        System.out.println("Dequeued: " + q.dequeue()); 
        System.out.println("Front now: " + q.peek());   
        System.out.println("Size: " + q.size());        
    }
}