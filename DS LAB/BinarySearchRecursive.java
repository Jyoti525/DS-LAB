public class BinarySearchRecursive {

    
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2; 

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[mid] < key) {
            return binarySearch(arr, mid + 1, high, key);
        }

        return binarySearch(arr, low, mid - 1, key);
    }

    // Driver method
    public static void main(String[] args) {
        // Sorted array
        int[] arr = {5, 6, 7, 8, 9, 10};
        int key = 10;
        int n = arr.length;

        // Function call
        int result = binarySearch(arr, 0, n - 1, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Index: " + result);
        }
    }
}
