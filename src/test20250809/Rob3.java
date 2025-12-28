package test20250809;

public class Rob3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp = new int[n+1];  // 记录从第0户人家起，抢到第i户人家时最多能抢多少钱，当然觉得0没有意义从1开始也可以Rob
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
