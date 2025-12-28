package test20250809;

import java.util.Arrays;

/**
 * 接雨水
 * 按行求解
 * 答主算法-仍然超时
 */
public class Trap5 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height){
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                // 这里设计非常巧妙，一小块一小块地存水，既是每小块存水的开始也是清算结束
                // 如果没有遇到第二个 墙 堵住存的水，前面虽然temp_sum++了，但不会计入总数中，和实际情况相符
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private static int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
}
