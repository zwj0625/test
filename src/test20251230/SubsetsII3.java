package test20251230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II，nums中可能含有重复元素-二进制位运算；逐个枚举；深度优先遍历和回溯
 * 回溯 核心挑战在于如何避免产生一模一样的子集 ---》先排序，再剪枝。
 */
public class SubsetsII3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        List<List<Integer>> res = new ArrayList<>();
        res = subsets(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res, sub);
        return res;
    }

    public static void backtrack(int[] nums, int i, List<List<Integer>> res, List<Integer> sub){
        res.add(new ArrayList<>(sub));

        for(int j=i;j<nums.length; j++){
            if(j>i && nums[j]==nums[j-1]){ // 剪枝条件 j > 0（只要当前的数字和数组里前一个数字相同就跳过） vs j > i（不是第一次尝试这个“位置”的数字才跳过。）
                continue;
            }
            sub.add(nums[j]);
            backtrack(nums, j+1, res, sub);
            sub.remove(sub.size()-1);
        }
    }
}
