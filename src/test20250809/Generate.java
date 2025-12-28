package test20250809;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 动态规划
 */
public class Generate {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j==0 || j==i){
                    curRow.add(1);
                }else{
                    // 主要是掌握ArrayList里怎么随机访问，调用get方法
                    int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    curRow.add(sum);
                }
            }
            result.add(curRow);
        }
        return result;
    }
}
