package test20260511;

/**
 * 打家劫舍 - 整数数组每个元素代表一户人家，不能同时偷相邻的两户人家，计算偷完最大金额
 */
public class Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        // 不难理解，到任意位置 n 时的最大金额，只有两种情况：要么刚偷完上一家，这家不能偷，那就还是偷到上一家的总金额；要么就是偷的上上家，到这家时就能偷
        // 动态规划方程 dp[n] = Max ( dp[n-1], dp[n-2]+nums[n] )
        int n = nums.length;
        int[] dp = new int[n];
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2;i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
