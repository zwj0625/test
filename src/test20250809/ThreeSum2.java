package test20250809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 */
public class ThreeSum2 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        // 得到不包含重复三元组->枚举的三元组 (a,b,c) 满足 a≤b≤c，保证了只有 (a,b,c) 这个顺序会被枚举到，而 (b,a,c)、(c,b,a) 等等这些不会，这样就减少了重复
        // m枚举a
        int first;
        for(first = 0; first < n; first++){
            if(nums[first]>0){  // 如果当前数字大于0，则三数之和一定大于0，所以结束循环，此题无解
                break;
            }
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            // 第一层循环内部转化为两数之和的问题->1,双指针；2,哈希表
            int third = n-1;
            // second为左指针，third为右指针
            int second = first+1;
            while(second<third){
                int sum = nums[first]+nums[second]+nums[third];
                if(sum==0){
                    list.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    while(second < third && nums[second]==nums[second+1]){
                        second++;
                    }
                    while(second < third && nums[third]==nums[third-1]){
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
