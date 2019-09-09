package 笔试.华为笔试;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-28 19:16
 * @Version 1.0
 */
public class 矩阵相邻搜索 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},
                {11, 12, 13, 14, 15},
                {21, 22, 23, 24, 25},
                {31, 32, 33, 34, 35},
                {41, 42, 43, 44, 45}
        };
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                List<Integer> temp = new ArrayList<>();
                if ((i - 1) >= 0) {
                    temp.add(arr[i - 1][j]);
                }
                if ((i + 1) < 5) {
                    temp.add(arr[i + 1][j]);
                }
                if ((j - 1) >= 0) {
                    temp.add(arr[i][j - 1]);
                }
                if ((j + 1) < 5) {
                    temp.add(arr[i][j + 1]);
                }
                map.put(arr[i][j], temp);
            }
        }

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.nextLine();
            if(s1 == null || s1.equals("")){
                return;
            }
            String[] split = s1.split(" ");
            int[] a = new int[6];
            for (int i = 0; i < 6; i++) {
                a[i] = Integer.valueOf(split[i]);
            }
            System.out.println(fun(map,a));
        }
        scanner.close();

    }

    public static int fun(Map<Integer, List<Integer>> map, int[] arr) {
        Set<Integer> result = new HashSet<>();
        result.addAll(map.get(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            if(!result.contains(arr[i])){
                return 0;
            }
            result.addAll(map.get(arr[i]));
            for (int j = 0; j <= i; j++) {
                result.remove(arr[j]);
            }
        }
        return 1;
    }
}
