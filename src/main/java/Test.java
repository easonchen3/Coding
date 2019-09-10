import java.util.HashMap;

public class Test {

    public static void main(String[] args){
        System.out.println(fun(Long.MAX_VALUE));
    }

    private static long fun(long x){
        long sum = 0;
        while(x > 5){
            x /= 5;
            sum += x;
        }
        return sum;
    }
}