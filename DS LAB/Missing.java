public class Missing {
    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 5};
      int n = 5;
      int missingNumber = findMissingNumber(arr, n);
      System.out.println("Missing number: " + missingNumber);
    }
  
    public static int findMissingNumber(int[] arr, int n) {
      int sum = (n * (n + 1)) / 2;
      int sums = 0;
  
      for (int num : arr) {
        sums += num;
      }
  
      return sum -sums;
    }
}