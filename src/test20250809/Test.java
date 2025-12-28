package test20250809;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

    }
    public static int trap(int[] height){
        if(height==null || height.length<=1){
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        Arrays.fill(leftMax, 0);
        Arrays.fill(rightMax, 0);

        // 记录每根柱子左侧最大值---从左往右遍历
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }
        // 记录每根柱子右侧最大值---从右往左遍历
        for (int i = n-2; i >=0 ; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }

        // 遍历height数组，计算存水量
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if(height[i]<min){
                sum+=min-height[i];
            }
        }

        return sum;
    }
}
