package test20250809;

/**
 * 盛最多的水的容器
 * 双指针
 */
public class MaxArea2 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height){
        int n = height.length;
        int res = -1;
        int left = 0;
        int right = n-1;
        while(left<right){
            int resTemp = (right-left)*Math.min(height[left], height[right]);
            if(resTemp>res){
                res = resTemp;
            }
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}

