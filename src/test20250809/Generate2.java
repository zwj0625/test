package test20250809;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 动态规划
 */
public class Generate2 {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> curRow = new ArrayList<>();
            for(int j=1;j<=i;j++){
                if(j==1 || j==i){
                    curRow.add(1);
                }else{
                    int sum = result.get(i-2).get(j-2) + result.get(i-2).get(j-1);
                    curRow.add(sum);
                }
            }
            result.add(curRow);
        }
        return result;
    }
}
