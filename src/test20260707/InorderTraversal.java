package test20260707;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 */
public class InorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res){
        // 递归出口
        if(root==null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int num){
        this.val = num;
    }
}
