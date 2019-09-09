/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 10:47
 * @Version 1.0
 */
public class 九宫格 {
    private static int[][] a = new int[10][10];
    public static void main(String[] args){
       a[3][1]=a[1][3] = 2;
       a[4][6]=a[6][4] = 5;
       a[7][9]=a[9][7] = 8;
       a[1][7]=a[7][1] = 4;
       a[2][8]=a[8][2] = 5;
       a[3][9]=a[9][3] = 6;
       int sum = 0;
        for (int i = 4; i <= 9 ; i++) {
            sum+=(f(i,""));
        }
        System.out.println(sum);
    }

    public static int f(int len,String result){
        int sum = 0;
        if(len == 0){
            return 1;
        }
        for (int i = 0; i < 9; i++) {
            if(result.contains(i+"")){
                continue;
            }
            if(result.length() > 0){
                int x = result.charAt(result.length()-1) - '0';
                if(a[x][i] > 0 && !result.contains(a[x][i]+"")){
                    continue;
                }
            }
            sum+=f(len-1,result+i);
        }
        return sum;
    }
}
