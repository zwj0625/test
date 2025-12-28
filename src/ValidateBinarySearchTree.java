import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        for (int i = 0; i < list.size()-2; i++) {
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public static void inorderTraversal(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,list);

        list.add(root.val);

        inorderTraversal(root.right,list);
    }
}
/*public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}*/
