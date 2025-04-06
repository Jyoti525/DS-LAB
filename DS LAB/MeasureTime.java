// Summation of n numbers and measures time
public class MeasureTime {
    public int summation(int n){
        int sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args) {
        MeasureTime mt=new MeasureTime();
        long starttime=System.currentTimeMillis();
        mt.summation(10000000);
        long endtime=System.currentTimeMillis();
        double timetaken=(endtime-starttime)/1000.0;
        System.out.println(timetaken);
        
    }
}
