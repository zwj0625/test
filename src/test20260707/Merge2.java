package test20260707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class Merge2 {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals){
        // 处理空数组边界
        if (intervals.length == 0) {
            return new int[0][];
        }
        // 先给区间按左端点递增的顺序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int[] interval: intervals){
            if(interval[0]<=res.get(res.size()-1)[1]){  // 需要合并
                int[] temp = new int[2];
                temp[0] = Math.min(interval[0], res.get(res.size()-1)[0]);
                temp[1] = Math.max(interval[1], res.get(res.size()-1)[1]);
                res.remove(res.size()-1);
                res.add(temp);
            }else{
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
