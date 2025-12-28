package test20250809;

/**
 * 盛最多水的容器
 * 双层循环
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height){
        int res = Integer.MIN_VALUE;
        int n = height.length;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                int resTemp = (j-i)*Math.min(height[i],height[j]);
                if(resTemp>res){
                    res = resTemp;
                }
            }
        }
        return res;
    }
}
