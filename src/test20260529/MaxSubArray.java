package test20260529;

/**
 * 最大子数组和---动态规划，子问题不明显
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums){
        int n = nums.length;
        int[] dp = new int[n]; // dp[i]对应nums[i]结尾的最大子数组和
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if(dp[i-1]>0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                // dp[i-1]为负数，越加越小
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
