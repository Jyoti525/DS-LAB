public class Deque {

    int[] arr;
    int front;
    int rear;
    int size;

    public Deque(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = 0;
    }

    // Checks whether the queue is full
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || front == rear + 1;
    }

    // Checks whether the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Function to insert element at rear end
    public void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        arr[rear] = key;
    }

    // Deletes element at front end
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    // Deletes element at rear end
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
    }

    // Returns front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[front];
    }

    // Returns rear element
    public int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[rear];
    }

    
    public static void main(String[] args) {
        Deque dq = new Deque(5);

        System.out.println("Insert element at rear end: 5");
        dq.insertRear(5);

        System.out.println("Insert element at rear end: 10");
        dq.insertRear(10);

        System.out.println("Insert element at rear end: 15");
        dq.insertRear(15);

        System.out.println("Get rear element: " + dq.getRear());

        dq.deleteRear();

        System.out.println("After delete rear, new rear is: " + dq.getRear());
        System.out.println("Get front element: " + dq.getFront());

        dq.deleteFront();

        System.out.println("After delete front, new front is: " + dq.getFront());
    }
}
