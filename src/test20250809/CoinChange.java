package test20250809;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1
 * 动态规划（自底向上）
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount){
        if(coins==null || coins.length==0){
            return -1;
        }
        int[] memory = new int[amount+1];
        memory[0] = 0; // 凑0元不需要硬币
        // 计算从1开始凑都至少需要多少硬币
        for (int curAmount = 1; curAmount < amount+1; curAmount++) {
            int minCoins = Integer.MAX_VALUE;// 初始化最初值
            // 内部是计算凑各个钱数的分叉选择
            for(int j = 0; j < coins.length; j++){
                if(curAmount-coins[j]>=0 && memory[curAmount-coins[j]]!=-1){   // 注意;memory[curAmount-coins[j]]!=-1这个判断必须要，如果不要{2}找3的时候就有问题
                    minCoins = Math.min(minCoins, memory[curAmount-coins[j]]+1);
                }
            }
            memory[curAmount] = (minCoins==Integer.MAX_VALUE) ? -1:minCoins;
        }
        return memory[amount];
    }
}
