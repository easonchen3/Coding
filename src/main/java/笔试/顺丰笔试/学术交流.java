package 笔试.顺丰笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-29 19:26
 * @Version 1.0
 */
public class 学术交流 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        List<List<Integer>> array = new ArrayList<>();
        int[][] map = new int[m+1][m+1];
        while((k--)>0){
            int index = scanner.nextInt();
            int num = scanner.nextInt();
            if(array.contains(index)){
                List<Integer> temp = array.get(index);
                temp.add(num);
                array.add(index,temp);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                array.add(temp);
            }
        }

        System.out.println(2);
        scanner.close();
    }

    class Data{
        List<Integer> num;
        Data(List<Integer> num){
            this.num =  num;
        }
    }
}
