package test20250809;

public class MoveZeroes {
    public static void main(String[] args) {

    }
    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    public static void moveZeros(int[] nums){
        if(nums.length < 2){
            return;
        }
        // 快慢指针
        int fast = 1;
        int slow = 0;
        while(nums[slow]!=0 && fast<nums.length){
            fast++;
            slow++;
        }
        // 一次遍历完成交换：慢指针永远指向0，快指针永远在找非零数
        while (fast < nums.length) {
            if(nums[fast]!=0){
                // 交换快慢指针指向的数
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                // 交换后，此时慢指针指向的一定是非零数，快指针指向的零
                fast++;
                slow++;
                // 此时慢指针指向的一定是零，快指针指向的不一定是非零数
            }else{
                fast++;
            }
        }
    }
}
