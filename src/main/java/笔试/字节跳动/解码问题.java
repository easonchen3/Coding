package 笔试.字节跳动;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-08 19:55
 * @Version 1.0
 */
public class 解码问题 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String strings = scanner.nextLine();
        scanner.close();

        LinkedList<Character>  l = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        fun(strings,0,result,l);
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < result.size(); i++) {
            set.add(result.get(i));
        }
        Iterator<String> iterator = result.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void fun(String strings,int index,LinkedList<String> result,LinkedList<Character> l){
        if(index >= strings.length()){
            char[] arr= new char[l.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = l.get(i);
            }
            result.addLast(new String(arr));
            return ;
        }
        l.addLast((char)(strings.charAt(index) - '0' - 1 + 'A'));
        fun(strings,index+1,result,l);
        l.removeLast();
        if(index +1 < strings.length() && strings.charAt(index) <= '2' && strings.charAt(index+1) <= '6'){
            char c= (char)((strings.charAt(0) - '0')*10+strings.charAt(1) - '0' - 1 + 'A');
            l.addLast(c);
            fun(strings,index+2,result,l);
        }
    }
}
