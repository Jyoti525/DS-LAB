import java.util.Scanner;

public class Array2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[]={23,45,56,78,89};
        // insertion of element in array
        System.out.println("Enter the element to insert in the array : ");
        int element = sc.nextInt();
         System.out.println("Enter the index to insert : ");
         int index = sc.nextInt();
        int newarr[] = new int[arr.length+1];
        for(int i=0 ;i< index ;i++){
            newarr[i] =arr[i];
        }
        newarr[index] = element;
        for(int i= index ;i<arr.length ;i++){
            newarr[i+1]=arr[i];
        }
        System.out.println("After insertion :" );
        for(int i =0 ;i< newarr.length ;i++){
            System.out.println(newarr[i]);
        }
        // for deletion
        int pos=2;
        for (int i= pos; i < newarr.length - 1; i++) {
            newarr[i] = newarr[i + 1];
        }
        System.out.println("Array after deletion:");
        for (int i = 0; i < newarr.length-1; i++) {
            System.out.print(newarr[i]+" ");
        }
        
      sc.close();

    }

}