import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangeRotting(grid));
    }

    public static int orangeRotting(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        //新鲜橘子数
        int cnt = 0;
        //每个橘子腐烂耗时，数组初始化为-1
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -1);
        }
        //定义方向向量
        int[] dis_x = {0,1,0,-1};
        int[] dis_y = {1,0,-1,0};
        //记录全部橘子腐烂时间
        int ans = 0;
        //腐烂橘子队列，先进先出，记录腐烂橘子的位置坐标
        Queue<Pair> Q = new LinkedList<>();
        //开始BFS广度优先遍历
        //第一次遍历先将grid中腐烂橘子加入Q
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==2){
                    //说明橘子初始就是腐烂的，加入Q
                    Q.add(new Pair(i,j));
                    //同时应当记录腐烂时间为0
                    dis[i][j] = 0;
                }else if(grid[i][j]==1){
                    //说明橘子初始是新鲜的，新鲜橘子计数加一
                    cnt++;
                }
            }
        }
        //接下来就是不断遍历队列Q中的腐烂橘子，对其上下左右进行腐烂、记录时间、腐烂后加入Q，至Q为空
        while(!Q.isEmpty()){
            //得到Q首个腐烂橘子
            Pair pair = Q.remove();
            //遍历该橘子上下左右进行腐烂，需要做判断
            for (int k = 0; k < 4; k++) {
                int tempX = pair.getX() + dis_x[k];
                int tempY = pair.getY() + dis_y[k];
                //判断符合条件：
                // 1.坐标合法，目标位置上下左右合法；2.未被访问过的橘子，不是真的没被访问过，因为我们将空格对应耗时也始终不赋值，始终未-1；3.不是空格确保是新鲜橘子
                if(tempX>=0 && tempX<n && tempY>=0 && tempY<m && dis[tempX][tempY]==-1 && grid[tempX][tempY]==1){
                    //对新鲜橘子进行腐烂
                    //腐烂时间加一
                    dis[tempX][tempY] = dis[pair.getX()][pair.getY()] + 1;
                    //新鲜橘子减一
                    cnt--;
                    //新腐烂的橘子加入到Q
                    Q.add(new Pair(tempX,tempY));
                    //更新ans腐烂耗时
                    ans = dis[tempX][tempY];
                    //目的是计算橘子全部腐烂耗时，考虑新鲜橘子数量为0但队列Q中还有待遍历腐烂橘子，这时不用管Q了
                    if(cnt==0){
                        break;
                    }
                }
            }
        }
        //到这里存在多种情况：
        //1.新鲜橘子数量为0但队列Q中还有待遍历腐烂橘子；2.新鲜橘子不为0队列Q已空；3.cnt=0且Q空
        return cnt==0?ans:-1;
    }
}

class Pair{
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
