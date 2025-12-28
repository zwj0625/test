package test20250809;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target){
        // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
        // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        int n = nums.length;
        int left =0;
        int right = n-1;
        int mid = -1;
        while(left<right){
            mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                return mid;
            }
        }
        // 到这步，说明没找到，需要找位置插入
        if(nums[left]<target){  // 要么大要么小，不可能等于
            return left+1;
        }else{
            return left;
        }
    }
}
