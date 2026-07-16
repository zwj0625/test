package test20260707;

public class SearchMatrix {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target){
        // 每一行内部整数从左到右升序排列；
        // 每一行第一个整数，大于上一行最后一个整数。
        // 抻成一维数组
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;

        while (left<=right){
            int mid = left+(right-left)/2;
            // 把mid映射回对应二维数组的索引
            int row = mid/n;
            int col = mid%n;
            int val = matrix[row][col];

            if(val==target){
                return true;
            }else if(val<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
