import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue1 queue = new Queue1(5);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Enqueue (Add element)");
            System.out.println("2. Dequeue (Remove element)");
            System.out.println("3. Peek (View front element)");
            System.out.println("4. Check if Queue is Empty");
            System.out.println("5. Check if Queue is Full");
            System.out.println("6. Display Queue Size");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Queue is full. Cannot enqueue.");
                    } else {
                        System.out.print("Enter the element to enqueue: ");
                        int element = scanner.nextInt();
                        queue.enqueue(element);
                        System.out.println(element + " enqueued to the queue.");
                    }
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        int dequeuedElement = queue.dequeue();
                        System.out.println(dequeuedElement + " dequeued from the queue.");
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty. No front element.");
                    } else {
                        int frontElement = queue.peek();
                        System.out.println("Front element is: " + frontElement);
                    }
                    break;

                case 4:
                    System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                    break;

                case 5:
                    System.out.println(queue.isFull() ? "Queue is full." : "Queue is not full.");
                    break;

                case 6:
                    System.out.println("Current queue size is: " + queue.size());
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }
}

class Queue1 {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor to initialize the queue
    public Queue1(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Utility function to add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
    }

    // Utility function to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Returning -1 to indicate an error
        }

        int item = queue[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    // Utility function to return the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Returning -1 to indicate an error
        }
        return queue[front];
    }

    // Utility function to return the size of the queue
    public int size() {
        return count;
    }

    // Utility function to check if the queue is empty
    public boolean isEmpty() {
        return (size() == 0);
    }

    // Utility function to check if the queue is full
    public boolean isFull() {
        return (size() == capacity);
    }
}