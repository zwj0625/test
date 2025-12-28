package test20250809;

import java.util.Arrays;

public class NumSquares {
    public static void main(String[] args) {

    }
    public static int numSquares(int n){
        int[] dp = new int[n + 1];  //一维数组 dp，其中 dp[i] 表示和为 i 的完全平方数的最少数量
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1;i<n+1;i++){
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);  // 未初始化的数组默认为0，取最小值记录肯定要将其初始化为最大整数
            }
        }
        return dp[n];
    }
}
