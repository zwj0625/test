package test20250809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 */
public class ThreeSum3 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        // first第一个数
        int first;
        for(first = 0;first<n;first++){
            if(nums[first]>0){
                break;
            }
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
            int second = first+1;
            int third = n-1;
            while(second<third){
                int sum = nums[first]+nums[second]+nums[third];
                if(sum==0){
                    list.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    while(second<third && nums[second]==nums[second+1]){
                        second++;
                    }
                    while(second<third && nums[third]==nums[third-1]){
                        third--;
                    }
                    second++;
                    third--;
                }else if(sum<0){
                    second++;
                }else if(sum>0){
                    third--;
                }
            }
        }
        return list;
    }
}
