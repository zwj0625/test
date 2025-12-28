package test20250809;

/**
 * 两次二分查找
 * 对矩阵的第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
 */
public class SearchMatrix {
    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1}};
        int target = 2;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int column = matrix[0].length;
        System.out.println(row);
        System.out.println(column);
        // 定位target在哪一行，找到最后一个小于target的行---可以改为二分查找
        int i = 0;
        while(matrix[i][column-1]<target){
            i++;
            // 所有行都不满足条件的话，说明矩阵里不可能找到目标值，直接返回false
            if(i>=row){
                return false;
            }
        }
        // 如果正好当前行末尾元素为目标值，直接返回true
        if(matrix[i][column-1]==target){
            return true;
        }
        // 在行内定位target的列---二分查找
        int j_left = 0;
        int j_right = column-1;
        while(j_left<=j_right){
            int j_mid = (j_left+j_right)/2;
            if(matrix[i][j_mid]==target){
                return true;
            }else if(matrix[i][j_mid]>target){
                j_right = j_mid -1;
            }else{
                j_left = j_mid +1;
            }
        }
        return false;
    }
}
