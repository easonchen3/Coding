package 剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 16:26
 * @Version 1.0
 */
public class 最大小组数 {
    public static void main(String[] args){
    }

    public static int fun(Integer[] parts){
        int i = 0;
        Arrays.sort(parts,(a,b)->b-a);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (i = 0; i < parts.length; i++) {
            queue.add(parts[i]);
        }
        int sum = 0;
        while(true){
            Integer t1 = queue.poll();
            Integer t2 = queue.poll();
            Integer t3 = queue.poll();
            if(t3 == 0){
                break;
            }else{
                sum+=t3;
                t1-=t3;
                t2-=t3;
                t3 = 0;
                queue.add(t1);
                queue.add(t2);
                queue.add(t3);
            }
        }
        return sum;

    }
}
