package test20251230;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集-二进制位运算；逐个枚举；深度优先遍历和回溯
 * 逐个枚举：循环枚举/递归枚举 循环遍历数组，每增加一个元素就是在原来每个子集的基础上分别追加当前元素构成一个新的子集，添加到结果集中
 */
public class SubSets2 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> subSets(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<>();
        res.add(empty);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for(int j=0; j<size; j++){
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(nums[i]);
                res.add(cur);
            }
        }
        return res;
    }
}
