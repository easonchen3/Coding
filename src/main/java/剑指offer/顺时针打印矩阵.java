package 剑指offer;

import java.util.ArrayList;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 15:08
 * @Version 1.0
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args){
       int[][] matrix = new int[][]{
               {1,2,3,4,5}
       };
        System.out.println(printMatrix(matrix));
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int len = (m%2 == 0)?m/2:m/2+1;
        if(n == 1){
            for (int i : matrix[0]) {
                res.add(i);
            }
            return res;
        }
        if(m == 1){
            for (int i = 0; i < matrix.length; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < m-i-1; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i; j < n-i-1 ; j++) {
                res.add(matrix[j][m-i-1]);
            }
            for (int j = m-i-1; j > i ; j--) {
                res.add(matrix[n-i-1][j]);
            }
            for (int j = n-i-1; j > i ; j--) {
                res.add(matrix[j][i]);
            }
            if(m == n && (m-i-1 == i) && (n-i-1) == i){
                res.add(matrix[i][i]);
            }
        }
        for (Integer re : res) {
            System.out.print(re+"\t");
        }
        System.out.println();
        return res;
    }
}
