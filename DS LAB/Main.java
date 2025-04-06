class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private StackNode top;

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push an item to the stack
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop an item from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Print stack
    public void print() {
        StackNode current = top;
        System.out.println();
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.println();
    }

    // Insert an item at the bottom of the stack
    public void insertAtBottom(int item) {
        if (isEmpty()) {
            push(item);
        } else {
            int temp = pop();
            insertAtBottom(item);
            push(temp);
        }
    }

    // Reverse the stack
    public void reverse() {
        if (!isEmpty()) {
            int temp = pop();
            reverse();
            insertAtBottom(temp);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);

        System.out.println("Original Stack:");
        s.print();

        s.reverse();

        System.out.println("Reversed Stack:");
        s.print();
    }
}
