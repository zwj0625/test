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
}
