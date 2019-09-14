package 笔试.百度笔试;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 19:46
 * @Version 1.0
 */
public class 叶子删除计划 {

    private static List<Integer> res = new ArrayList<>();
    private static int cnt = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = n;
        Map<Integer,List<Integer>> map = new HashMap<>();
        while((x--) > 1){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(map.containsKey(a)){
                map.get(a).add(b);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a,list);
            }
            if(!map.containsKey(b)){
                map.put(b,new ArrayList<>());
            }
        }
        fun(map,n);
        for (int i = res.size()-1; i >=0 ; i--) {
            System.out.print(res.get(i)+" ");
        }
        scanner.close();
    }

    public static void fun(Map<Integer,List<Integer>> map,int n){
        int sum = 0;
        while(true){
            if(sum == n-1){
                res.add(cnt);
                break;
            }
            cnt++;
            List<Integer> detel = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
                List<Integer> list1 = integerListEntry.getValue();
                if(list1.size() == 0 || list1 == null){
                    detel.add(integerListEntry.getKey());
                }
            }
            for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
                List<Integer> list1 = integerListEntry.getValue();
                if(list1 != null && list1.size() > 0){
                    ListIterator<Integer> iterator = list1.listIterator();
                    while(iterator.hasNext()){
                        int x = iterator.next();
                        if(detel.contains(x)){
                            iterator.remove();
                            sum++;
                            res.add(cnt);
                        }
                    }
                }

            }

        }
        /*List<Integer> integers = map.get(k);
        if(integers.size() == 0){
            return ;
        }
        ListIterator<Integer> iterator = integers.listIterator();
        cnt ++;
        while(iterator.hasNext()){
            int x = iterator.next();
            if(!map.containsKey(x)){
                res.add(cnt);
                iterator.remove();
            }
            fun(map,x);
        }*/
    }

}
