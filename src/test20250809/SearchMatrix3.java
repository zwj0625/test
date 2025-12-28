package test20250809;

/**
 * 两次二分查找
 * 对矩阵的第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
 */
public class SearchMatrix3 {
    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = new int[][]{{1}};
        int target = 1;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target){
        // 1. 补充边界条件：矩阵为空或每行空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        // 2. 快速判断：目标值超出矩阵范围
        if (matrix[0][0] > target || matrix[row - 1][column - 1] < target) {
            return false;
        }

        // 3. 修正行定位：二分找到最大的i，使matrix[i][0] <= target
        int i_left = 0;
        int i_right = row - 1;
        while (i_left < i_right) {
            // 向上取整计算mid，避免死循环（关键修正）
            int i_mid = (i_left + i_right + 1) / 2;
            if (matrix[i_mid][0] <= target) {
                // 当前行第一列 <= target，可能在当前行或更下行
                i_left = i_mid;
            } else {
                // 当前行第一列 > target，目标在更上行
                i_right = i_mid - 1;
            }
        }
        // 循环结束后，i_left即为目标可能所在的行

        // 4. 修正列查找：在定位行中二分查找目标
        int j_left = 0;
        int j_right = column - 1;
        while (j_left <= j_right) { // 循环条件改为j_left <= j_right，确保所有位置被检查
            int j_mid = (j_left + j_right) / 2;
            if (matrix[i_left][j_mid] == target) {
                return true; // 找到目标
            } else if (matrix[i_left][j_mid] > target) {
                // 中间元素 > 目标，目标在左侧
                j_right = j_mid - 1;
            } else {
                // 中间元素 < 目标，目标在右侧
                j_left = j_mid + 1;
            }
        }

        // 列查找结束仍未找到
        return false;
    }
}
