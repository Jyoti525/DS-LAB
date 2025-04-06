import java.util.ArrayList;

class CircularQueue {

    private int size, front, rear;
    private ArrayList<Integer> queue;

    // Constructor
    CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
        this.queue = new ArrayList<>(size);

        // Initialize the ArrayList with nulls to set capacity
        for (int i = 0; i < size; i++) {
            queue.add(null);
        }
    }

    // Method to insert a new element in the queue
    public void enQueue(int data) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1 + size) % size)) {
            System.out.println("Queue is Full");
            return;
        }

        // Condition for empty queue
        if (front == -1) {
            front = 0;
            rear = 0;
            queue.set(rear, data);
        }
        // Wrap rear to 0 if it reaches the end and front is not at 0
        else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, data);
        }
        // Normal case
        else {
            rear = (rear + 1) % size;
            queue.set(rear, data);
        }
    }

    // Function to dequeue an element
    public int deQueue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int temp = queue.get(front);
        queue.set(front, null); // Optional: clear the slot

        // If the queue now becomes empty
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % size;
        }

        return temp;
    }

    // Method to display the queue
    public void displayQueue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Elements in the circular queue are: ");

        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue.get(i) + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(queue.get(i) + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue.get(i) + " ");
            }
        }

        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);

        q.displayQueue();

        int x = q.deQueue();
        if (x != -1) {
            System.out.println("Deleted value = " + x);
        }

        x = q.deQueue();
        if (x != -1) {
            System.out.println("Deleted value = " + x);
        }

        q.displayQueue();

        q.enQueue(9);
        q.enQueue(20);
        q.enQueue(5); // Should say "Queue is Full" if full

        q.displayQueue();

        q.enQueue(20); // Try to enqueue when full
    }
}
