package test20260707;

/**
 * 镜像对称二叉树
 */
public class IsSymmetric {
    public static void main(String[] args) {

    }
    public static boolean isSymmetric(TreeNode root){
        return check(root.left, root.right);
    }
    public static boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }else{
            return p.val==q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }
}
