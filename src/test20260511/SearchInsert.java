package test20260511;

/**
 * 二分查找 - 主要是理解记住边界条件; 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 5));
    }
    public static int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        while(left<=right){
            if(target<nums[mid]){
                right = mid-1;
                mid = (left+right)/2;
            }else if(target>nums[mid]){
                left = mid+1;
                mid = (left+right)/2;
            }else{
                return mid;
            }
        }
        return left;
    }
}
