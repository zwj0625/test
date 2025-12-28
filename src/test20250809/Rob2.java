package test20250809;

/**
 * 打家劫舍
 * 递归-超出时间限制
 */
public class Rob2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        return recursion(nums, n-1);
    }
    public static int recursion(int[] nums, int i){
        // 基线条件：没有房屋可抢
        if (i < 0) {
            return 0;
        }
        if(i+1==1){
            return nums[0];
        }
        if(i+1==2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(recursion(nums, i-1), recursion(nums, i-2)+nums[i]);
    }
}
