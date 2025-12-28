package test20250809;

public class SearchInsert2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target){
        // 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
        // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        // 说明target没找到->也存在有但是没找到的情况 nums=[1];target=1
        if(nums[left]>target){ // 插到前面
            return left;
        }else if(nums[left]<target){  // 插到后面
            return left+1;
        }else{  // nums[left]=target
            return left;
        }
    }
}
