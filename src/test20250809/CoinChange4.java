package test20250809;

public class CoinChange4 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        if(coins==null || coins.length==0){
            return -1;  // 1 <= coins.length <= 12
        }
        int[] memory = new int[amount+1];
        memory[0] = 0;  // 动态规划一定要想好怎么处理0、1这种边界情况
        for (int i = 1; i < amount+1; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++){
               if(i -coins[j]>=0 && memory[i -coins[j]]!=-1){
                   minCoins = Math.min(minCoins, memory[i -coins[j]]+1);
               }
            }
            memory[i] = (minCoins==Integer.MAX_VALUE)?-1:minCoins;
        }
        return memory[amount];
    }
}
