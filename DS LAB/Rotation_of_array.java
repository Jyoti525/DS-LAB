// Java code to implement array rotation using a temporary array
public class Rotation_of_array {

    // Function to rotate array to the left by d positions
    static void rotate(int[] arr, int d, int n) {
        int[] temp = new int[n];
        int j = 0;

        // Store elements from index d to end
        for (int i = d; i < n; i++) {
            temp[j++] = arr[i];
        }

        // Store first d elements
        for (int i = 0; i < d; i++) {
            temp[j++] = arr[i];
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // Function to print elements of array
    static void printTheArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // For clean output
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int N = arr.length;
        int d = 2;

        // Function call
        rotate(arr, d, N);
        printTheArray(arr, N);
    }
}
