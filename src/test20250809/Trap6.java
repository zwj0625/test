package test20250809;

/**
 * 按列计算
 */
public class Trap6 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height){
        int column = height.length;
        int waterSum = 0;
        for (int i = 0; i <column ; i++) {
            int leftMax = 0;
            int rightMax = 0;
            // 找到左侧最大的 墙
            for(int left=i;left>=0;left--){
                if(height[left]>leftMax){
                    leftMax = height[left];
                }
            }
            // 找到右侧最大的 墙
            for(int right=i;right<column;right++){
                if(height[right]>rightMax){
                    rightMax = height[right];
                }
            }
            //计算当前列的存水量->三种情况：当前列比最低的墙矮；当前列比最低的墙高；当前列和最低的墙一样高（后面两种都存不住水）
            if(height[i]<Math.min(leftMax, rightMax)){
                waterSum+= Math.min(leftMax, rightMax)-height[i];
            }
        }
        return waterSum;
    }
}
