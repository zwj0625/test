package test20250809;

import java.util.Arrays;

/**
 * 接雨水
 * 按行求解
 * 方法对，但超时了
 */
public class Trap2 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height){
        // 开始应该下意识想到特殊/极端情况
        if(height.length==0){
            return 0;
        }
        // 基本类型数组转为流，获取最大值
        int row = Arrays.stream(height).max().getAsInt();
        int[] wall = new int[row+1];
        int res = 0;
        // 分行计算存水量
        for(int i=1;i<=row;i++){
            int j = 0;
            // 找到这一行开始存水的位置
            while(j<height.length && height[j]<i){
                j++;
            }
            // System.out.println(j);
            // 计算每行的 墙 在哪里，行内，倒着找更快 也有规律
            int k = height.length-1;
            // 倒着 只需找到第一个比 i 大或等于 i 的数的位置，即停止存水的位置（墙）
            while(k>=0 && height[k]<i){
                k--;
            }
            // 找到此行的墙的位置后，记录下来
            wall[i] = k;

            while(j<wall[i]){
                if(height[j]<i){
                    res++;  // 对于最后需要特殊处理-》封口
                }
                j++;
            }
        }
        return res;
    }
}
