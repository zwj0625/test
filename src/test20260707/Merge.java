package test20260707;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间（二维数组）---先排序
 */
public class Merge {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals){
        if(intervals.length==0){
            return new int[0][2];
        }
        // 先给二维数组排序，比较每个一维数组的第一个元素大小，按升序（关键是学习怎么给二维数组排序、定规则）
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size()-1);
            if(last[1] >= intervals[i][0]){
                int[] cur = new int[2];  // 数组是引用类型，List存的是数组的地址，需要在循环内创建cur，循环外创建一次所有存到List的cur都会改变值
                // 满足合并条件 --- last 和当前 interval 合并
                cur[0] =last[0];
                cur[1] = Math.max(intervals[i][1], last[1]);  // 注意 是比较谁的右端最大取谁，左端不需要比较因为排过序
                merged.remove(merged.size()-1);
                merged.add(cur);
            }else{
                merged.add(intervals[i]);  // 如果当前区间不用合并，不要忘记直接加入到结果集
            }
        }
        return merged.toArray(new int[merged.size()][]);  // 注意List转Array的方法
    }
}
