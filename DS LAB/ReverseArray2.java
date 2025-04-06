public class ReverseArray2 {

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

    public static void main(String[] args) {
        int[] arr = {11,12,13,14,15};

        System.out.print("Original Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        reverseArray(arr, 0, arr.length - 1);

        System.out.print("\nReversed Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
