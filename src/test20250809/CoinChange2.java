package test20250809;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1
 * 递归（自顶向下）+记忆化搜索
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    // 递归，但不去除重复---超出时间限制
//    public static int coinChange(int[] coins, int amount){
//        if(amount==0){
//            return 0;
//        }
//        if(coins.length==0){
//            return -1;
//        }
//        if(amount<0){
//            return -1;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i=0;i<coins.length;i++){
//            int sub = coinChange(coins, amount-coins[i]);
//            if(sub==-1){
//                continue;
//            }
//            res = Math.min(res, sub+1);
//        }
//        return (res == Integer.MAX_VALUE) ? -1:res;
//    }

    static int[] memory;
    public static int coinChange(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        if(coins.length==0){
            return -1;
        }
        if(amount<0){
            return -1;
        }
        memory = new int[amount];  // 为什么要另写函数，是确保 memory 只初始化一次
        return findWay(coins, amount);
    }

    public static int findWay(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        if(coins.length==0){
            return -1;
        }
        if(amount<0){
            return -1;
        }
        if(memory[amount-1]!=0){
            return memory[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount-coins[i]);
            if(res>=0 && res<min){
                min = res +1;
            }
        }
        memory[amount-1] = (min==Integer.MAX_VALUE?-1:min);
        return memory[amount-1];
    }
}
