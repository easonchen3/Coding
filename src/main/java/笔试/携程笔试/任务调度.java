package 笔试.携程笔试;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-04 20:25
 * @Version 1.0
 */
public class 任务调度 {

    public static void main(String[] args){
        System.out.println(schedule(2,new int[]{1,5,3,4,2}));
    }

        static int schedule(int m,int[] array) {
            int cnt = 0,max = Integer.MIN_VALUE;
            int sum = 0;
            Data[] data = new Data[array.length];
            for (int i = 0; i < array.length; i++) {
                data[i] = new Data(array[i],i);
            }
            Arrays.sort(data, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    return o1.val - o2.val;
                }
            });

        int i = 0,j=array.length-1;
        while(i<=j){
            if(Math.abs(data[i].index - data[j].index) == 1){
                sum += data[i].val;
                sum+= data[j].val;
                if(sum >max) max = sum;
                i++;j--;
                sum = 0;
            }else{
                cnt++;j--;
            }
        }
        return max;
    }

    static class Data{
        int val;
        int index;
        public Data(int val,int index){
            this.val = val;
            this.index = index;
        }
    }
}
