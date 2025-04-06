// Java code to implement the above approach 
// Java code to implement array rotation
public class RotationOfArray {

    public static void rotate(int[] arr, int d, int n) {
        d = d % n; // Handle d greater than n

        for (int p = 0; p < d; p++) {
            int first = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = first;
        }

        // Print the rotated array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Optional line break
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        int d = 2; // Rotate 2 times

        rotate(arr, d, n);
    }
}
