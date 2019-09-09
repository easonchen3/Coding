package 笔试.京东笔试;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 19:47
 * @Version 1.0
 */
public class 合唱队形 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Data[] data = new Data[n];
        for (int i = 0; i < n; i++) {
            int high = scanner.nextInt();
            data[i] = new Data(high,i+1);
        }


        System.out.println(fun(data));
    }

    public static int fun(Data[] stu){
        Arrays.sort(stu);
        for (Data data : stu) {
            System.out.println(data.id+" "+data.high);
        }
        int cnt = 0;

        for (int i = 1; i < stu.length; i++) {
            int dis = stu[i].id - stu[i-1].id;
            if(dis != -1){
                cnt++;
            }
        }
        return cnt+1;
    }

    static class Data implements Comparable<Data>{
        int high;
        int id;

        public Data(int high, int id) {
            this.high = high;
            this.id = id;
        }

        @Override
        public int compareTo(Data o) {
            return this.high-o.high;
        }
    }


}
