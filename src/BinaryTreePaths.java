import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        tree.left = node1;
        tree.right = node2;
        node1.right = node3;

        System.out.println(binaryTreePaths(tree));
    }

    public static List<String> binaryTreePaths(TreeNode root){
        List<String> paths = new ArrayList<>();
        constructPaths(root,"",paths);
        return paths;
    }

    private static void constructPaths(TreeNode root, String path, List<String> paths) {
        if(root!=null){
            StringBuilder pathSb = new StringBuilder(path);
            pathSb.append(root.val);
            if(root.left==null&&root.right==null){
                paths.add(pathSb.toString());
            }else{
                pathSb.append("->");
                constructPaths(root.left,pathSb.toString(),paths);
                constructPaths(root.right,pathSb.toString(),paths);
            }
        }
    }
}
class TreeNode {
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
 }