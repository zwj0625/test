package test20260511;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

    }
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int coin: coins){
                if(coin<=i && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        // 这里和完全平方数不一样，完全平方数所有自然数都能拆成最多 4 个完全平方数之和
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];  // 凑不出金额时 dp[amount] 还是最大值，题目要求返回 -1，你直接返回原值会报错。
    }
}
