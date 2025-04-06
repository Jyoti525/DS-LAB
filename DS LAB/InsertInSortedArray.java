public class InsertInSortedArray {

    public static int insertSorted(int[] arr, int n, int key, int capacity) {
        // If array is already full
        if (n >= capacity) {
            return n;
        }

        int i;
        // Shift elements to the right until the correct position is found
        for (i = n - 1; (i >= 0 && arr[i] > key); i--) {
            arr[i + 1] = arr[i];
        }

        // Insert the key at its correct position
        arr[i + 1] = key;

        return n + 1; // Return the new size
    }

    // Function to print array elements
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int capacity = 20;
        int[] arr = new int[capacity];

        arr[0] = 2;
        arr[1] = 6;
        arr[2] = 10;
        arr[3] = 20;
        arr[4] = 30;
        arr[5] = 40;

        int n = 6; // Current number of elements
        int key = 26;

        System.out.print("Before Insertion: ");
        printArray(arr, n);

        // Insert the key
        n = insertSorted(arr, n, key, capacity);

        System.out.print("After Insertion: ");
        printArray(arr, n);
    }
}
