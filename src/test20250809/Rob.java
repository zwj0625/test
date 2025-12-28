package test20250809;

/**
 * 打家劫舍1
 * 动态规划
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        // 特殊情况
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if(n==1){
            return nums[0];
        }else if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];  // 记录n间房屋偷完对应的最大金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {  // 从第三个开始计算
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
