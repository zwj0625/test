public class Main {
    public static void main(String[] args){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum solution = new MinPathSum();
        System.out.println(solution.minPathSum(grid));
    }
}