package test20260707;

/**
 * 二叉树的最大深度 --- 其实就是遍历
 */
public class MaxDepth {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth)+1;
        }
    }
}
