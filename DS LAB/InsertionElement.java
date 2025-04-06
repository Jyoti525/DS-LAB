import java.util.Scanner;
public class InsertionElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of elements:");
        int n=sc.nextInt();
        int[] array=new int[n];
        System.out.println("enter elements:");
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.println(array[i]);
        }

        System.out.println("element to insert:");
        int Newelement=sc.nextInt();
        System.out.println("enter index:");
        int index=sc.nextInt();
        int[] array1=new int[n+1];

        for(int i=0;i<index;i++){
            array1[i]=array[i];
        }
        // array1[0]=Newelement;
        array1[index]=Newelement;

        for(int i=index;i<n;i++){
            array1[i+1]=array[i];
        }
        for(int i=0;i<array1.length;i++){
            System.out.println(array1[i]);
        }
        System.out.println("delete index:");
        int delArr=sc.nextInt();
        int[] Arr2=new int[n];

        for(int i=0;i<index;i++){
            Arr2[i]=array1[i];
        }
        Arr2[index]=delArr;

        for(int i=index;i<n;i++){
            Arr2[i-1]=array1[i+1];
        }
        for(int i=0;i<Arr2.length;i++){
            System.out.println(Arr2[i]);
        }

    }
    
}
