package test20250809;

import java.util.Arrays;

/**
 * 完全平方数
 * 递归+记忆化数组
 */
public class NumSquares2 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        // 创建备忘录数组，初始值为 -1 表示未计算
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private static int dfs(int n, int[] memo) {
        // 基例：n 为 0
        if (n == 0) {
            return 0;
        }

        // 如果已经计算过，直接返回结果
        if (memo[n] != -1) {
            return memo[n];
        }

        // 检查 n 是否是完全平方数
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            memo[n] = 1;
            return 1;
        }

        int minCount = Integer.MAX_VALUE;
        // 遍历所有可能的完全平方数（从大到小，可能更快找到解）
        for (int i = sqrt; i >= 1; i--) {
            int square = i * i;
            int count = 1 + dfs(n - square, memo);
            if (count < minCount) {
                minCount = count;
            }
        }

        // 保存结果到备忘录
        memo[n] = minCount;
        return minCount;
    }
}
