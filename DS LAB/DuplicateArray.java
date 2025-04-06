import java.util.Scanner;
public class DuplicateArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of elements:");
        int n=sc.nextInt();
        int[] array1=new int[n];
        System.out.println("enter elements:");
        for(int i=0;i<n;i++){
            array1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.println(array1[i]);
        }
        System.out.println("remove duplicate value:");
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(array1[i]==array1[j]){
                    System.out.println(array1[j]);
                    
                }
            }
        }
    }
}