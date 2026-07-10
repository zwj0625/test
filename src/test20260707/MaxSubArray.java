package test20260707;

public class MaxSubArray {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int subSum = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            // if(subSum+nums[i]>nums[i]){  // 只要拼接后的总和没超过历史全局最大值，就直接抛弃前面一段、以当前数字重新开局。丢失最优解的可能性。
            if(subSum+nums[i]>nums[i]){
                subSum+=nums[i];
            }else{
                subSum = nums[i];
            }
            maxSum = Math.max(subSum, maxSum);
        }
        return maxSum;
    }
}
