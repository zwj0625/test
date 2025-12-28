package test20250809;

/**
 * 一次二分查找
 * 将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素
 */
public class SearchMatrix2 {
    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1}};
        int target = 2;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target){
        return false;
    }
}
