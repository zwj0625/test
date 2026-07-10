package test20260529;

import java.util.Arrays;

/**
 * 原地移动零--双指针
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZeros(nums)));
    }

    public static int[] moveZeros(int[] nums){
        int n = nums.length;
        int left =0, right = 0;
        while(right < n){
            if(nums[right]!=0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return nums;
    }
    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
