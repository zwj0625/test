package test20250809;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 动态规划
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        int maxRes = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {  // 外层循环是遍历nums数组
            int maxTemp = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++){  // 内层循环遍历nums[i](dp[i])前面的dp元素---dp[i]为找到的前面dp最大值+1
                if(nums[j]<nums[i]){
                    maxTemp = Math.max(maxTemp, dp[j]);
                }
            }
            dp[i] = (maxTemp==Integer.MIN_VALUE) ? 1:maxTemp+1;
            if(dp[i] > maxRes){
                maxRes = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));  // dp数组计算正确
        return maxRes;
    }
}
