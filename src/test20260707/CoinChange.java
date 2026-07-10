package test20260707;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        if(amount==0){
            return 0;
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < amount+1; i++) {
            for(int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
