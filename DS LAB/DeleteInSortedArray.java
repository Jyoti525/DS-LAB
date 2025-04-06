public class DeleteInSortedArray {

    // Binary search to find the index of the element to delete
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;
        else if (arr[mid] < key)
            return binarySearch(arr, mid + 1, high, key);
        else
            return binarySearch(arr, low, mid - 1, key);
    }

    // Function to delete an element
    public static int deleteElement(int[] arr, int n, int key) {
        int pos = binarySearch(arr, 0, n - 1, key);

        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        // Shift elements to the left to delete the element
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return n - 1; // Return new size of the array
    }

    // Main function to test the above code
    public static void main(String[] args) {
        int[] arr = new int[100]; // Larger array for shifting
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        int n = 5; // Initial size
        int key = 30;

        System.out.println("Array before deletion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Delete element
        n = deleteElement(arr, n, key);

        System.out.println("\n\nArray after deletion:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
