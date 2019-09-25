import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-22 09:00
 * @Version 1.0
 */
public class Main4 {

    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a; i++) {
            s.append("A");
        }
        for (int i = 0; i < b; i++) {
            s.append("B");
        }
        quan(s.toString().toCharArray(), 0);
        System.out.println(set.size());
        for (String s1 : set) {
            System.out.println(s1);
        }
        scanner.close();
    }

    public static void quan(char[] str, int start) {
        if (start < 0 || start > str.length) {
            return;
        }
        if (start == str.length - 1) {
            longestPalindrome(new String(str));
        } else {
            for (int i = start; i < str.length; i++) {
                swap(str, i, start);
                quan(str, start + 1);
                swap(str, i, start);
            }
        }

    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len =chars.length;
        int ans = 0;
        int[] ne = new int[1000000];
        Get_ne(chars,ne,len);
        for(int i=1;i<len;++i)
        {
            int k=i+1;
            if(k%(k-ne[k])==0&&k/(k-ne[k])!=1){
                set.add(s.substring(k/(k-ne[k]),k));
            }
        }

    }

    static void Get_ne(char[] T,int[] ne,int L)
    {
        ne[0]=-1;
        int i=0,j=-1;
        while(i<L)
        {
            if(j<0||T[i]==T[j]) ne[++i]=++j;
            else j=ne[j];
        }
    }

}
