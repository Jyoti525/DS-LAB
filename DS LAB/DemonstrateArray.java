import java.util.Scanner;

public class DemonstrateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        System.out.print("Enter elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        int sum = 0;
        System.out.println("Array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
            sum += array[i];
        }

        double avg = (double) sum / size;
        System.out.println("\nSum of array elements: " + sum);
        System.out.println("Average of array elements: " + avg);

        System.out.print("Enter the element to search: ");
        int search = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < size; i++) {
            if (array[i] == search) {
                System.out.println( " found at index " + i);
                found = true;
                break; 
            }
        }

        if (!found) {
            System.out.println(" Not found in the array.");
        }
        System.out.print("Enter the a index number:");
        int idx1=sc.nextInt();
        System.out.print("Enter the another index number:");
        int idx2=sc.nextInt();
        int diff=0;
        if(array[idx1]>array[idx2]){
            diff=array[idx1]-array[idx2];
        }else{
            diff=array[idx2]-array[idx1];
        }
        System.out.println("The difference is:"+diff);

        sc.close();
    }
}