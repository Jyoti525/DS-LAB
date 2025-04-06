import java.util.Stack;

public class ReverseArrayUsingStack {

    // Function to reverse array using stack
    public static void reverseArrayUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        for (int num : arr) {
            stack.push(num);
        }

        // Pop elements from the stack 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    // Utility to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        reverseArrayUsingStack(arr);

        System.out.print("Reversed Array: ");
        printArray(arr);
    }
}
