package 笔试.笔试360;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-31 17:30
 * @Version 1.0
 */
public class 散步 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        /*HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            fun1(n,i,arr,0,set);
        }*/
        System.out.println(fun(arr,n));
    }

    public static void fun1(int n,int now,int[] data,int index,HashSet<Integer> set){
        if(data.length == index){
            set.add(now);
            return ;
        }
        if(now-data[index] >= 1){
            fun1(n,now-data[index],data,index+1,set);
        }

        if(now +data[index] <= n){
            fun1(n,now+data[index],data,index+1,set);
        }
    }

    public static int fun(int[] arr,int n){
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        list.add(arr[0]);
        for (int j = 1; j < arr.length; j++) {
            List<Integer> temp  = new ArrayList<>(list);
            ListIterator<Integer> iterator = list.listIterator();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                System.out.println(next);
                if(next+arr[j] <= n){
                    iterator.add(next+arr[j]);
                }
                if(next-arr[j] >= 1){
                    iterator.add(next-arr[j]);
                }
            }
            list.removeAll(temp);
        }
        int sum = 0;
        for (Integer integer : list) {
            System.out.println(integer);
        }
        return sum;
    }

}
