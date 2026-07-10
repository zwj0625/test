package test20260707;

public class Rob {
    public static void main(String[] args) {

    }

    public static int rob(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        // dp[3] = Math.max(dp[1]+nums[2], dp[2]);  // 得到状态转移方程 dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1])
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[n];
    }
}
