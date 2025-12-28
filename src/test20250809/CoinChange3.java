package test20250809;

import java.util.Arrays;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1
 * 递归（自顶向下）+记忆化搜索
 */
public class CoinChange3 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount){
        // 要兑换0元不需要任何硬币
        if(amount==0){
            return 0;
        }
        // 没有硬币或者要兑换小于0的情况都是非法无解的
        if(coins == null || coins.length==0 || amount<0){
            return -1;
        }
        // 记忆化数组：索引i直接对应金额i，长度amount+1（覆盖0~amount）
        int[] memory = new int[amount + 1];
        Arrays.fill(memory, -2);
        memory[0] = 0; // 基础条件：金额0需要0个硬币
        int minCoins = dfs(coins, amount, memory);
        return minCoins;
    }

    // 递归辅助函数，传递memory数组，避免重复初始化
    public static int dfs(int[] coins, int amount, int[] memory){
        // 要兑换0元不需要任何硬币
        if(amount==0){
            return 0;
        }
        // 没有硬币或者要兑换小于0的情况都是非法无解的
        if(coins == null || coins.length==0 || amount<0){
            return -1;
        }
        // 判断memory中是否已经记录当前amount结果
        // 已计算过，直接返回缓存结果
        if (memory[amount] != -2) {
            return memory[amount];
        }
        int minCoins = Integer.MAX_VALUE;
        // 循环遍历coins，相当于分叉选择不同硬币
        for (int i = 0; i < coins.length; i++) {
            int subResult = dfs(coins, amount-coins[i], memory);
            // 子问题有解，更新最小硬币数
            if (subResult != -1) {
                minCoins = Math.min(minCoins, subResult + 1);
            }
        }
        // 缓存当前金额的结果（无法兑换则记为-1）
        memory[amount] =  (minCoins==Integer.MAX_VALUE?-1:minCoins);
        return memory[amount];
    }
}
