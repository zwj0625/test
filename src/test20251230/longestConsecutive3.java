package test20251230;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续子序列的长度
 * 要求时间复杂度O(n)就不能用排序，排序最优的快排要nlogn
 */
public class longestConsecutive3 {
    public static void main(String[] args) {
        int nums[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLength = 0;
        for (int num: set) {
            int count = 1;
            if(!set.contains(num-1)){
                while(set.contains(num+count)){
                    count++;
                }
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
