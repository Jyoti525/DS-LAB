public class ReverseArray4 {

    // Recursive function to reverse arr[] from start to end
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr, start + 1, end - 1);
    }

    // Utility to print the array
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method to test above functions
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int size = arr.length;

        printArray(arr, size);

        reverseArray(arr, 0, size - 1);

        System.out.println("Reversed array is:");
        printArray(arr, size);
    }
}
