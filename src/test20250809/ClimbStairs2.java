package test20250809;

/**
 * 爬楼梯
 * 递归---超出时间限制
 */
public class ClimbStairs2 {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n){
        if(n<=2){
            return n;
        }else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
}
