public class ReverseArray3 {

    // Function to reverse arr[] from start to end
    public static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Utility that prints out an array on a line
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver function to test above functions
    public static void main(String[] args) {
        int[] arr = {21,22,23,24,25};
        int n = arr.length;

        printArray(arr, n);
        reverseArray(arr, 0, n - 1);
        System.out.println("Reversed array is:");
        printArray(arr, n);
    }
}
