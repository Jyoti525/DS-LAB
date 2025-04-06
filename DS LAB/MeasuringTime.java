public class MeasuringTime {
    // A function that calculates the sum of numbers from 0 to n using formula
    public int summation(int n){
        return n*(n-1)/2;
    }
    public static void main(String[] args) {
        MeasuringTime mtt=new MeasuringTime();
        long starttime=System.currentTimeMillis();
        mtt.summation(10000000);
        long endtime=System.currentTimeMillis();
        double timetaken=(endtime-starttime)/1000.0;
        System.out.println(timetaken);
    }
}
