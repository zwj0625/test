package test20250809;

/**
 * 爬楼梯
 * 动态规划
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n){
        int[] dp = new int[n+1];  // dp[n]=n阶楼梯的爬法种数
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
