package 笔试.搜狗笔试;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-08 16:50
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int k = scanner.nextInt();
       int n = scanner.nextInt();
       Data[] data = new Data[2];
       int len = 0;
        Set<Integer> nums = new HashSet<>();
       while((n--) > 0){
           int x = scanner.nextInt();
           int root = scanner.nextInt();
           nums.add(root);
           List<Integer> list = new ArrayList<>();
           int a ;
           for (int i = 0; i < x-1; i++) {
               a = scanner.nextInt();
               nums.add(a);
               list.add(a);
           }
           data[len++] = new Data(root,list);
       }

        int fun = fun(k, data,nums.size());
        System.out.println(fun);
        scanner.close();
    }

    public static int fun(int k,Data[] data,int num){
        int len = k;
        int sum = 0;
        int temp = 0;
        List<Integer> list = new ArrayList<>();
        list.add(data[0].root);

        while(list.size() < num){
            ListIterator<Integer> iterator = list.listIterator();
            while(iterator.hasNext()){
                Integer i = iterator.next();
                len = k;
                List<Integer> remove = new ArrayList<>();
                for (int j = i+1; j < data.length && len>0; j++) {
                    if(data[i].child.contains(data[j].root)){
                        remove.add(data[j].root);
                        iterator.add(data[j].root);
                        len--;
                    }
                }
                data[i].child.removeAll(remove);
                while(!data[i].child.isEmpty() && len > 0){
                    data[i].child.remove(0);
                    len--;
                }

            }
            sum++;
        }
        return sum;
    }

    static class Data{
        int root;
        List<Integer> child ;
        Data(int root,List<Integer> child){
            this.root = root;
            this.child = child;
        }
    }
}
