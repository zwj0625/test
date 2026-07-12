package test20260707;

import java.util.Arrays;

/**
 * 轮转数组 k --- 最好是原地
 */
public class RotateArray {
    public static void main(String[] args) {

    }

    public static void rotateArray(int[] nums, int k){
        // 时间复杂度高，空间复杂度达到最优（原地翻转）
        int n = nums.length;
        k = k % n;
        for(int j = 0; j < k; j++){
            int curLast = nums[n-1];
            for (int i = n-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = curLast;
        }
    }

    public static void rotate(int[] nums, int k){
        // 空间复杂度O(n)，时间复杂度最优O(n)
        int n = nums.length;
        k = k % n;
        int[] copy = new int[n];
        copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n-k; i++) {
            nums[i+k] = copy[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = copy[n-k+i];
        }
    }

    // 最好的方法是三步翻转：
    // 1 翻转整个数组
    // 2 翻转前 k 个元素
    // 3 翻转后 n−k 个元素
    // 单独写一个反转数组区间的函数
    public static void rotate1(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start]  = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
