package 笔试.奇安信;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 19:30
 * @Version 1.0
 */
public class 结束进程数 {

    static int num = 0;

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        String[] split1 = scanner.nextLine().split(" ");
        String[] split2 = scanner.nextLine().split(" ");
        String kill = scanner.nextLine();
        scanner.close();

        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < split2.length; i++) {
            if(map.containsKey(split2[i])){
                map.get(split2[i]).add(split1[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(split1[i]);
                map.put(split2[i],list);
            }
        }
        fun1(map,kill);
        System.out.println(num+1);
    }


    public static void fun1(HashMap<String,ArrayList<String>> map,String key){
        if(key == null){
            return;
        }
        ArrayList<String> list = map.get(key);
        if(list!=null){
            num += list.size();
            for (int i = 0; i < list.size(); i++) {
                fun1(map,list.get(i));
            }
        }
    }
}
