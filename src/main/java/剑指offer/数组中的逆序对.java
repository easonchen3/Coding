package 剑指offer;

/**
 *
 * 超时
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 20:36
 * @Version 1.0
 */
public class 数组中的逆序对 {
    public static void main(String[] args){
        System.out.println(InversePairs(new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575}));
    }

    public static int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < array.length-1; i++) {
            int key = array[i];
            for (int j = i+1; j < array.length ; j++) {
                if(array[j] < key){
                    cnt++;
                }
            }
        }

        return cnt%1000000007;
    }
}
