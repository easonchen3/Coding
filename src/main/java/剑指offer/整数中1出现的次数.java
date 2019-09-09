package 剑指offer;

/**
 * 代码太差，执行时间过长
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 13:53
 * @Version 1.0
 */
public class 整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num+=(fun(i));
        }
        return num;
    }
    
    public int fun(int n){
        int num = 0;
        for (int i = n; i >= 0 ; i/=10) {
            int temp = i%10;
            num=num + ((temp==1)?1:0);
        }
        return num;
    }
}
