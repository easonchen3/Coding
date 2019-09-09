package com.baiguo.other.leetcode;

import org.apache.commons.lang.ArrayUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-05-09 10:22
 * @Version 1.0
 */

@SuppressWarnings("all")
public class Solution {
    public static void main(String[] args) {
        System.out.println(champagneTower(3,2));
    }

    public static int champagneTower(int i,int j){
        if(i==1){
            return 1;
        }
        if(j==1){
            return 1+2*champagneTower(i-1,j);
        }
        if(j>=i){
            return 1+2*champagneTower(i-1,j-1);
        }
        else{
            return 1+champagneTower(i-1,j-1)+champagneTower(i-1,j);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            int len = nums2.length;
            if(len%2==0){
                return (nums2[len/2]+nums2[len/2-1])/2.0;
            }else{
                return nums2[len/2];
            }
        }
        if(nums2 == null || nums2.length == 0){
            int len = nums1.length;
            if(len%2==0){
                return (nums1[len/2]+nums1[len/2-1])/2.0;
            }else{
                return nums1[len/2];
            }
        }
        if(nums1.length == 1&& nums2.length ==1){
            return (nums1[0]+nums2[0])/2.0;
        }
        int i=0,j=0,temp = 0;
        int length = nums1.length + nums2.length;
        int sum = length/2+1;
        int[] num3 = new int[length];
        while(i<nums1.length || j<nums2.length){
            if(i< nums1.length && nums1[i]<nums2[j]){
                num3[temp++] = nums1[i++];
            }else{
                num3[temp++] = nums2[j++];
            }
            if(sum == temp){
                if(length%2==0){
                    return (num3[temp-1]+num3[temp-2])/2.0;
                }else{
                    return num3[temp-1];
                }
            }
        }
        return 0;
    }

    public static int heightChecker(int[] heights) {
        int[] result = Arrays.copyOf(heights,heights.length);
        Arrays.sort(result);
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]!=result[i]){
               sum++;
            }
        }
        return sum;
    }
    public static int countNumbersWithUniqueDigits(int n) {
        int x = 9,sum=0,result = 9;
        for(int i = 1;i<n;i++){
            result = result*(x--);
            sum += result;
        }
        return sum+10;
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        int flag = 0,num1,num2,curr;
        int i = A.length-1;
        List<Integer> list = new ArrayList<>();
        while(i>=0 || K>0){
            num1 = (i>=0)?A[i]:0;
            num2 = (K>0)?K%10:0;
            curr = num1+num2+flag;
            list.add(curr%10);
            flag = curr/10;
            i--;K/=10;
        }
        if(flag!=0){
            list.add(flag);
        }
        Collections.reverse(list);
        return list;
    }

    public static String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null){
            return null;
        }
        char[] first = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] seconde = new StringBuilder(num2).reverse().toString().toCharArray();
        int i = 0,j=0,cnt = 0;
        StringBuilder result = new StringBuilder();
        while(i<first.length || j<seconde.length){
            int a1 = (i>=first.length)?0:first[i]-'0';
            int a2 = (j>=seconde.length)?0:seconde[j]-'0';
            int temp = (a1+a2+cnt);
            result.append(temp%10);
            cnt = temp/10;
            i++;j++;
        }
        if(cnt != 0){
            result.append(cnt);
        }
        return result.reverse().toString();
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        res = Math.max(res,(left+right));
        return res;
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) &&
                isMirror(t1.right,t2.left) &&
                isMirror(t1.left,t2.right);
    }

    public List<Integer> getRows(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long m = 1;
        for (int i = 0; i <= rowIndex; i++) {
            result.add((int)m);
            m*= (rowIndex-i)/(i+1);
        }
        return result;
    }

    public static boolean validMountainArray(int[] A) {
        if(A == null || A.length <=1 ){
            return false;
        }
        if(A[0] > A[1]){
            return false;
        }
        int top = 1;
        for (; top < A.length; top++) {
            if(A[top]<=A[top-1]){
                break;
            }
        }
        if(top == A.length){
            return false;
        }
        for(;top<A.length;top++){
            if(A[top-1]<=A[top]){
                return false;
            }
        }
        return true;

    }

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length <= 2){
            return false;
        }
        for(int i = 1;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max1 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int max2 = nums[nums.length-1]*nums[0]*nums[1];
        return max1>max2?max1:max2;
    }

    public int bitwiseComplement(int N) {
        if(N == 0){
            return 1;
        }
        int result = 0;
        for(int i = 1;N>0;i*=2){
            result +=(N&1^1)*i;
            N>>=1;
        }
        return result;
    }

    int title = 0;

    public int findTilt(TreeNode root) {
        reverse(root);
        return title;
    }

    public int reverse(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = reverse(root.left);
        int right = reverse(root.right);
        title += Math.abs(left-right);
        return left+right+root.val;
    }

    public static boolean hasAlternatingBits(int n) {
        if(n == 1){
            return false;
        }
        int ret = n&1;
        n = n >> 1;
        while(n!=1){
            int cnt = n&1;
            n>>=1;
            if(cnt == ret){
                return false;
            }
            ret = cnt;
        }
        return true;
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0 || timeSeries == null){
            return 0;
        }
        int times = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int jiange = timeSeries[i]-timeSeries[i-1];
            times+= (jiange>duration)?duration:jiange;
        }
        return times+duration;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int need = 0;
        if(flowerbed.length==1 && flowerbed[0]==0){
            return n<=1;
        }
        if(flowerbed[0]==0 && flowerbed[1]==0){
            flowerbed[0]=1;
            need++;
        }
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){
            flowerbed[flowerbed.length-1]=1;
            need++;
        }
        for (int i = 1; i < flowerbed.length-1; i++) {
            if(flowerbed[i]==0 && flowerbed[i+1]==0 && flowerbed[i-1]==0){
                flowerbed[i]=1;
                need++;
            }
        }
        return need>=n;
    }

    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if(c == '('){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(c);
                }

            }
        }
        return stack.size();
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char a : S.toCharArray()) {
            while(!stack1.isEmpty() && a=='#'){
                stack1.pop();
                break;
            }
            if(a!='#'){
                stack1.push(a);
            }
        }
        for (char b : T.toCharArray()) {
            while(!stack2.isEmpty() && b=='#'){
                stack2.pop();
                break;
            }
            if(b!='#'){
                stack2.push(b);
            }
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(!stack1.pop().equals(stack2.pop())){
                return false;
            }
        }
        if(stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public String addBinary(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);
        BigInteger result = num1.add(num2);
        return result.toString(2);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int temp = 0;
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            l3.next = new ListNode((x + y + temp) % 10);
            l3 = l3.next;
            temp = (x + y + temp) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (temp > 0) {
            l3.next = new ListNode(temp);
        }
        return head.next;
    }

    public static int[] productExceptSelf(int[] nums) {
        int mux = 1;
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = mux;
            mux *= nums[i];
        }
        mux = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            left[i] *= mux;
            mux *= nums[i];
        }
        return left;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0) {
            sqrt--;
        }
        return new int[]{area / sqrt, sqrt};
    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(helper(i, j));
            }
            result.add(list);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            list.add(helper(rowIndex, i));
        }
        return list;
    }

    public static int helper(int i, int j) {
        if (j == 0) {
            return 1;
        }
        if (j == 1) {
            return i;
        }
        if (j > i / 2) {
            return helper(i, i - j);
        }
        if (j > 1) {
            return helper(i - 1, j - 1) + helper(i - 1, j);
        }
        return 0;
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String word = paragraph.toLowerCase().replaceAll("[\\pP]", " ");
        String[] words = word.split("[ ]+");
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, (map.get(s)) + 1);
            } else {
                map.put(s, 1);
            }

        }
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(entry -> sortMap.put(entry.getKey(), entry.getValue()));
        for (Map.Entry<String, Integer> s : sortMap.entrySet()) {
            if (!set.contains(s.getKey())) {
                return s.getKey();
            }
        }
        return null;
    }

    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
    }

    public static boolean isUgly(int num) {
        if (num <= 1) {
            return num == 1 ? true : false;
        }
        if (num % 2 != 0) {
            return false;
        } else {
            while (num > 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else if (num % 3 == 0) {
                    num /= 3;
                } else if (num % 5 == 0) {
                    num /= 5;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int length = (num + "").length();
        System.out.println(length);
        while (num >= 10) {
            int result = 0;
            int num2 = num;
            for (; num2 > 0; num2 /= 10) {
                result += (num2 % 10);
            }
            num = result;
        }
        return num;
    }

    public static int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13) {
            return n;
        }
        int result = 0;

        while (n > 5) {
            if (n % 2 == 0) {
                result += 2;
                n /= 2;
            } else if (n % 3 == 0) {
                result += 3;
                n /= 3;
            } else if (n % 5 == 0) {
                result += 5;
                n /= 5;
            } else if (n % 7 == 0) {
                result += 7;
                n /= 7;
            } else if (n % 11 == 0) {
                result += 11;
                n /= 11;
            } else if (n % 13 == 0) {
                result += 13;
                n /= 13;
            } else if (n % 23 == 0) {
                result += 23;
                n /= 23;
            } else {
                return result + n;
            }
        }
        return result + ((n == 1) ? 0 : n);
    }

    public static int brokenCalc(int X, int Y) {
        if (X == 0) {
            return 0;
        }
        int num = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y /= 2;
                num++;
            } else {
                Y = Y / 2 + 1;
                num += 2;
            }
            System.out.println(Y);
        }
        return (X - Y) + num;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static String convertToBase7(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFu = false;
        if (num < 0) {
            num *= -1;
            isFu = true;
        }
        while (num != 0) {
            stringBuilder.append(num % 7);
            num /= 7;
        }
        String s = (isFu) ? "-" : "";
        return s + stringBuilder.reverse().toString();
    }

    public static int minDeletionSize(String[] A) {
        int result = 0;
        int i = 0;
        char[][] chars = new char[A.length][];
        for (String s : A) {
            chars[i++] = s.toCharArray();
        }
        for (int j = 0; j < chars[0].length; j++) {
            for (int k = 0; k < chars.length - 1; k++) {
                if (chars[k][j] > chars[k + 1][j]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }


    public static String complexNumberMultiply(String a, String b) {
        int index1 = a.lastIndexOf('+');
        int index2 = b.lastIndexOf('+');
        int a1 = Integer.parseInt(a.substring(0, index1));
        int a2 = Integer.parseInt(a.substring(index1 + 1, a.length() - 1));
        int b1 = Integer.parseInt(b.substring(0, index2));
        int b2 = Integer.parseInt(b.substring(index2 + 1, b.length() - 1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((a1 * b1) + (a2 * b2 * -1)).append('+').append((a1 * b2) + (a2 * b1)).append('i');
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static int islandPerimeter(int[][] grid) {
        int length = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    length += 4;
                }
                if (i >= 1 && grid[i - 1][j] == 1) {
                    length -= 2;
                }
                if (j >= 1 && grid[i][j - 1] == 1) {
                    length -= 2;
                }
            }
        }
        return length;
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        StringBuilder rex = new StringBuilder();
        List<Boolean> list = new ArrayList<>();
        rex.append("^").append(pattern.charAt(0));
        for (int i = 1; i < pattern.length(); i++) {
            rex.append(pattern.charAt(i)).append("[a-z]*");
        }
        rex.append("[a-z]*$");
        Pattern pattern1 = Pattern.compile(rex.toString());
        for (String query : queries) {
            Matcher matcher = pattern1.matcher(query);
            list.add(matcher.lookingAt());
        }
        return list;
    }

    public static int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }

    public static int coinChange(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                count += amount / coins[i];
                amount = amount % coins[i];
            }
            if (amount == 0) {
                return count;
            }
        }
        return -1;
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            int j;
            for (j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    break;
                }
                if (j == T.length - 1) {
                    j = i;
                    break;
                }
            }
            result[i] = j - i;
        }
        result[T.length - 1] = 0;
        return result;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] num = new int[set2.size()];
        for (Integer integer : set2) {
            num[j++] = integer;
        }
        return num;
    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new TreeSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int sum = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                sum++;
            }
        }
        return sum;
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] out = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    out[i][j] = 0;
                } else {
                    out[i][j] = Integer.MAX_VALUE - 1;
                    if (i > 0) {
                        out[i][j] = Math.min(out[i][j], out[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        out[i][j] = Math.min(out[i][j], out[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (i < rows - 1) {
                        out[i][j] = Math.min(out[i][j], out[i + 1][j] + 1);
                    }
                    if (j < cols - 1) {
                        out[i][j] = Math.min(out[i][j], out[i][j + 1] + 1);
                    }
                }
            }
        }
        return out;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode head = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        head.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        head.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return head;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }
        int max = 0;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                x++;
            } else {
                if (x > max) {
                    max = x;
                }
                x = 0;
            }
        }
        return max;
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int sum = 0;
        int back;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] > 5) {
                back = bills[i] - 5;
                sum -= back;
            }
            if (sum < 0) {
                return false;
            }
            sum += 5;
        }
        return true;

    }

    public static int longestPalindrome(String s) {
        int len = s.length();
        int sum = 0;
        boolean flag = false;
        int[] array = new int[58];
        for (int i = 0; i < len; i++) {
            array[s.charAt(i) - 'A']++;
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < 58; i++) {
            if (array[i] > 1) {
                sum += (array[i] / 2) * 2;
            }
            if (array[i] % 2 != 0) {
                flag = true;
            }
        }
        sum = sum + (flag ? 1 : 0);
        return sum;
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length - 1);
    }

    public static int quickSort(int[] nums, int k, int low, int high) {
        if (low <= high) {
            int position = postion(nums, low, high);
            if (position == k - 1) {
                return nums[position];
            } else if (position > k - 1) {
                return quickSort(nums, k, low, position - 1);
            } else {
                return quickSort(nums, k, position + 1, high);
            }
        } else {
            return -1;
        }
    }

    public static int postion(int[] nums, int left, int right) {
        int low = left;
        int high = right;
        int temp = nums[low];
        while (low < high) {
            while (nums[high] >= temp && low < high) {
                high--;
            }
            nums[low] = nums[high];
            while (nums[low] <= temp && low < high) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }


    public static int findJudge(int N, int[][] trust) {
        int[][] result = new int[N + 1][2];
        for (int[] ints : trust) {
            int out = ints[0];
            int in = ints[1];
            result[out][0]++;
            result[in][1]++;
        }
        for (int i = 1; i <= N; i++) {
            if (result[i][0] == 0 && result[i][1] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder a = new StringBuilder("a");
        String[] ss = S.split(" ");
        for (String s : ss) {
            char[] chars = s.toCharArray();
            boolean isYuan = false;
            char first = chars[0];
            StringBuilder newString = new StringBuilder();
            if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u' ||
                    first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U') {
                isYuan = true;
            }
            int index = isYuan ? 0 : 1;
            for (; index < chars.length; index++) {
                newString.append(chars[index]);
            }
            if (!isYuan) {
                newString.append(first);
            }
            newString.append("ma").append(a);
            a.append("a");
            result.append(newString).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();

    }

    public static int[][] flipAndInvertImage(int[][] A) {
        if (ArrayUtils.isEmpty(A)) {
            return null;
        }
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                if (A[i][j] != A[i][col - j - 1]) {
                    int temp = A[i][j];
                    A[i][j] = A[i][col - j - 1];
                    A[i][col - j - 1] = temp;
                }
            }
            System.out.println(Arrays.toString(A[i]));
            for (int j = 0; j < col; j++) {
                A[i][j] = A[i][j] ^ 1;
            }
            System.out.println(Arrays.toString(A[i]));
        }
        return A;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k >= nums.length) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        if (ArrayUtils.isEmpty(nums)) {
            return false;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res == 0;
    }


    public static int calPoints(String[] ops) {
        int sum = 0;
        int[] a = new int[ops.length];
        int j = 0;
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("+")) {
                a[j] = a[j - 1] + a[j - 2];
                j++;
            } else if (s.equals("D")) {
                a[j] = a[j - 1] * 2;
                j++;
            } else if (s.equals("C")) {
                j--;
            } else {
                a[j] = Integer.parseInt(s);
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            sum += a[i];
        }
        System.out.println(j);
        System.out.println(Arrays.toString(a));
        return sum;
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        return -1;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
