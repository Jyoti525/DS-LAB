
public class InsertElementAtPosition {

    // Function to insert element at a specific position
    public static void insertElement(int[] arr, int n, int x, int pos) {
        // Shift elements to the right
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = x;
    }

    // Utility function to print the array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = new int[15]; // Declared with extra space
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 15;
        arr[3] = 18;
        arr[4] = 25;

        int n = 5;
        int x = 10;
        int pos = 2;

        System.out.println("Before insertion:");
        printArray(arr, n);

        insertElement(arr, n, x, pos);
        n++; 

        System.out.println("After insertion:");
        printArray(arr, n);
    }
}
