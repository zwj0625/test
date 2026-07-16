package test20260707;

public class InvertTree {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root){
        if(root==null){
            return null;
        }else{
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
