package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-05 13:00
 * @Version 1.0
 */
public class 约瑟夫环 {

    public static void main(String[] args){
       yeseful(10,3);
    }

    public static void yeseful(int total,int countNum){
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            start.add(i);
        }
        int k = 0;
        while(start.size() > 0){
            k = k+countNum;
            k = k%(start.size()) -1;
            if(k < 0){
                System.out.print(start.get(start.size() - 1) + "\t");
                start.remove(start.size()-1);
                k = 0;
            }else{
                System.out.print(start.get(k) + "\t");
                start.remove(k);
            }
        }
    }
}
