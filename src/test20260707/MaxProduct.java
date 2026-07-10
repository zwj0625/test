package test20260707;

public class MaxProduct {
    public static void main(String[] args) {
        
    }

    // 遗漏考虑情况---负负得正，可能会有更大的
//    public static int maxProduct(int[] nums){
//        if(nums.length==1){
//            return nums[0];
//        }
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i-1]*nums[i], nums[i]);
//            if(dp[i]>max){
//                max = dp[i];
//            }
//        }
//        return max;
//    }

    public static int maxProduct(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i]));
            if(dpMax[i]>max){
                max = dpMax[i];
            }
        }
        return max;
    }

}
