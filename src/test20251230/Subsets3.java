package test20251230;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集-二进制位运算；逐个枚举；深度优先遍历和回溯
 * 回溯
 */
public class Subsets3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        res = subsets(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        backtrack(nums, 0, res, sub);
        return res;
    }

    public static void backtrack(int[] nums, int i, List<List<Integer>> res, List<Integer> sub){
        res.add(new ArrayList<>(sub));

        for(int j=i;j<nums.length; j++){
            sub.add(nums[j]);
            backtrack(nums, j+1, res, sub);
            sub.remove(sub.size()-1);
        }
    }
}
