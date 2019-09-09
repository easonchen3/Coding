package 笔试.滴滴笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-27 19:50
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s1 = scanner.nextLine();

       int num = Integer.valueOf(s1);
       String s = scanner.nextLine();
        System.out.println(fun(s,num));
       scanner.close();
    }

    public static  String fun(String s,int n){
        String[] split = s.split(" ");
        Data[] result = new Data[n];
        int k = 0;
        for (int i = 0; i < split.length; i+=2) {
            if((i+1) >= split.length){
                break;
            }
            Data data = new Data(Integer.valueOf(split[i]),split[i+1].charAt(0));
            result[k++] = data;
        }
        int i = 0;
        while(i<n-1){
            int j = i+1;
            if(result[i] == null || result[j]==null){
                break;
            }
            while(result[j].flag == result[i].flag && result[j].flag == '+'){
                j++;
            }
            sort(result,i,j);
            i = j;
            j = i+1;
            if(result[i] == null || result[j]==null){
                break;
            }
            if(result[i].flag == '*' && result[i].value > result[j].value){
                Data temp = result[i];
                result[i] = result[j];
                result[j] = temp;
            }
            i = j+1;
        }
        StringBuilder res = new StringBuilder();
        for (Data data : result) {
            if(data!=null){
                res.append(data.value).append(" ").append(data.flag).append(" ");
            }
        }
        res.append(split[split.length-1]);
        return res.toString();
    }

    public static void sort(Data[] arr,int start,int end){
        for (int i = start; i < end-1; i++) {
            for (int j = start+1; j < end; j++) {
                if(arr[i].value > arr[j].value){
                    Data temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



    static class Data{
        int value;
        char flag;
        Data(int value,char flag){
            this.value = value;
            this.flag = flag;
        }
    }
}

