package test20260707;

public class MoveZeros {
    public static void main(String[] args) {

    }

    public static void moveZeros(int[] nums){
        // 把零都移到后面，原地移动 --- 双指针
        // 左指针永远指向零？右指针指向非零？右指针一直找，找到非零就和左指针交换，两个++，找不到就自己++
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (left<n && nums[left]!=0){
            left++;
        }
        right = left;
        while(right<n){
            if(nums[right]!=0){
                nums[left] = nums[right];
                nums[right] = 0;
                right++;
                left++;
            }else{
                right++;
            }
        }
    }
}
