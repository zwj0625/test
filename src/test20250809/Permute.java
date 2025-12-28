package test20250809;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列问题
 * 迭代+回溯
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums){
        int length = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if(length==0){
            return res;
        }
        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();  // 模拟后进先出的栈
        dfs(nums, length, 0, path, used, res);
        return res;
    }

    public static void dfs(int[] nums, int length, int depth,
                           List<Integer> path, boolean[] used,
                           List<List<Integer>> res){
        // 遍历到叶子节点
        if(depth==length){
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子节点处，产生不同的分支：在还未选择的数中依次选择一个元素作为下一个元素的位置---循环实现
        for (int i = 0; i < length; i++) {
            if(!used[i]){// 当前数未被选择过，就会产生一个新路径
                path.add(nums[i]);
                used[i]=true;
                dfs(nums, length, depth+1, path, used, res);
                // 下面是回溯过程
                used[i]=false;
                path.remove(path.size()-1);  // remove掉最后一个元素
            }
        }
    }
}
