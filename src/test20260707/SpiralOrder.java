package test20260707;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 螺旋矩阵 --- 顺时针遍历
 */
public class SpiralOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return list;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = columns-1;
        int top = 0;
        int bottom = rows-1;

        while(left<=right && top<=bottom){
            // 一圈开始
            for (int i = left; i <=right ; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottom) break;

            for (int i = top; i <=bottom ; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(left>right) break;

            for (int i = right; i >=left ; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom) break;

            for (int i = bottom; i >=top ; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            // 一圈结束
        }
        return list;
    }
}
