/* Program to demonstrate time taken by function fun() */ 
import java.util.Scanner;
public class TimeConsuming {
    public void fun(){
        Scanner sc=new Scanner(System.in);
        System.out.println("fun() starts");
        System.out.println("Press enter to stop fun");
        sc.nextLine(); 
        System.out.println("fun() ends");
        sc.close();
    } 
    // The main program calls fun() and measures time taken by fun()  
    public static void main(String[] args) {
        TimeConsuming tc=new TimeConsuming();
        long starttime=System.currentTimeMillis();
        tc.fun();
        long endingtime=System.currentTimeMillis();
        double timetaken = (endingtime - starttime) / 1000.0;
        System.out.println(timetaken);
    }
}
 