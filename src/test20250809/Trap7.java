package test20250809;

import java.util.Arrays;

/**
 * 接雨水
 * 动态规划---一层循环
 */
public class Trap7 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height){
        int n = height.length;
        // 记录每列左侧最大墙和右侧最大墙（不含当前列）
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        max_left[0] = 0;// 首元素左侧最大值就是0
        max_right[n-1] = 0;// 尾元素右侧最大值就是0
        // 找左侧最大值正序遍历
        for (int i = 1; i < n; i++) {// 不用管首元素了，i-1 是不合法的
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }
        // 找右侧最大值反序遍历
        for (int i = n-2; i >=0 ; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }
        // 至此，已经记录了每列的左右墙
        System.out.println(Arrays.toString(max_left));
        System.out.println(Arrays.toString(max_right));
        // 再遍历 height 数组，计算每列存水量，并求和
        int waterSum = 0;
        for(int i=0;i<n;i++){
            int min = Math.min(max_left[i], max_right[i]);
            if(height[i]< min){
                waterSum+=min -height[i];
            }
        }
        return waterSum;
    }
}
