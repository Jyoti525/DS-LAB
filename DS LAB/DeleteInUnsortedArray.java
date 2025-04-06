public class DeleteInUnsortedArray {

    public static int findElement(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    // Function to delete the element from the array
    public static int deleteElement(int[] arr, int n, int key) {
        int pos = findElement(arr, n, key);

        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        // Shift elements to the left
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return n - 1;
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[100]; // Extra capacity for safety
        arr[0] = 10;
        arr[1] = 50;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 20;

        int n = 5;
        int key = 30;

        System.out.println("Array before deletion:");
        printArray(arr, n);

        n = deleteElement(arr, n, key);

        System.out.println("\nArray after deletion:");
        printArray(arr, n);
    }
}
