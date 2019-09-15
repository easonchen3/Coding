package 剑指offer;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-04 22:41
 * @Version 1.0
 */
public class 第K大的数 {
    public static void main(String[] args) {
        int[] arr = {22, 5, 8, 3, 1, 8, 4};
        System.out.println(sort(arr,arr.length,5));

    }

    public static int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    private static int getKth(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (true) {
            while (nums[left] < pivot && left < right) {
                left++;
            }
            while (nums[right] >= pivot && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }

        swap(nums, left, end);

        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }

    private static void swap(int[] nums, int n1, int n2) {
        int tmp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = tmp;
    }

    /**
     *     使用堆排的特点找
     */
    private static void buildHeap(int[] arr,int end){
        //从第一个非叶子节点开始建堆，直到根节点
        for (int currRoot = (end-1)/2; currRoot >= 0 ; --currRoot) {
            //左节点
            int leftSon = 2*currRoot +1;
            //右节点
            int rightSon = 2*currRoot+2;

            //设置max为左右节点中较大的节点
            int max = leftSon;
            if(rightSon <= end && arr[rightSon] > arr[leftSon]){
                max = rightSon;
            }
            //子节点中较大的节点和父节点交换
            if(arr[max] > arr[currRoot]){
                swap(arr,max,currRoot);
            }
        }
    }

    private static int sort(int[] arr,int num,int k){
        for (int last = num-1; last >= num-k-1; --last) {
            //循环建堆。
            buildHeap(arr,last);
            //每次把堆的顶部最大值交换到数组的末尾，不断缩小堆的大小。
            swap(arr,0,last);
        }
        return arr[num-k-1];
    }
}
