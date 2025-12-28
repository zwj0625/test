package test20250809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列问题
 * 迭代（每次迭代都复制创建新的变量，则不需要回溯过程）
 */
public class Permute2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> list = new ArrayList<>();  // 结果集
        if(nums.length==0){
            return list;
        }
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n];
        int depth = 0;
        dfs(list, path, used, depth, nums);
        return list;
    }

    public static void dfs(List<List<Integer>> list, List<Integer> path, boolean[] used, int depth, int[] nums){
        if(depth==nums.length){
            list.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                // 1、每一次尝试都创建新的变量表示当前的"状态"--->不需要回溯过程
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                boolean[] newUsed = Arrays.copyOf(used, nums.length);
                newUsed[i] = true;
                dfs(list, newPath, newUsed, depth+1, nums);
            }
        }
    }
}
