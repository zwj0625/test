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
    }
}
