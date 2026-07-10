package test20260624;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 --- 双指针
 */
public class ThreeSum {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int left = 0;
        int right = 0;
        Arrays.sort(nums);  // 先排序
        for(int i=0; i<n; i++){  // 固定 第一位数
            if(i>0 && nums[i]==nums[i-1]){
                continue;  // 说明再从这个点找和前面是重复的
            }
            if(nums[i]>0){
                // continue;  // 三个数中最小的都比0大，后面肯定找不到了
                break;
            }
            left = i+1;  // 左指针起点
            right = n-1;  // 右指针起点
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    while(left<right && nums[left+1]==nums[left]){
                        left++;
                    }
                    while(left<right && nums[right-1]==nums[right]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
