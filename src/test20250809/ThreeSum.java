package test20250809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力枚举
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(1)
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        // 如果数组长度不足3
        if(nums==null || nums.length<3){
            return res;
        }
        Arrays.sort(nums); // 排序，方便去重

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-1;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<nums.length;k++){
                    if(k>j+1 && nums[k]==nums[k-1]){
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
