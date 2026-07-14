package test20260707;

/**
 * 搜索插入位置 --- 二分查找，返回插入点的索引位置
 */
public class SearchInsert {
    public static void main(String[] args) {

    }
    public static int searchInsert(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int mid = (left+right)/2;
        while (left<=right){
            if(nums[mid]<target){
                left = mid+1;
                mid = (left+right)/2;
            }else if(nums[mid]>target){
                right = mid-1;
                mid = (left+right)/2;
            }else{
                return mid;
            }
        }
        return left;
    }
}
