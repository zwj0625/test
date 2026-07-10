package test20251230;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列问题-回溯（每一次尝试都「复制」，则不需要回溯）
 */
public class Permute {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(int[] nums){
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.fill(used, false);
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    public static void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if(depth==len){// 到叶子节点了
            res.add(new ArrayList<>(path));
            return;
        }

        // 未到叶子节点，遍历nums，将未使用的元素追加到path中
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;

                // 递归
                dfs(nums, len, depth+1, used, path, res);
                // 回溯
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }

}
