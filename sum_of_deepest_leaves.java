// problem: given a binary tree, find the sum of the values of its deepest leaves
import java.util.*;

public class sum_of_deepest_leaves {
    public static void main(String[] args) {
    /*    TEST TREE
                    1
                /       \
               2         3
             /   \         \
            4     5         6
           /                 \
          7                   8
    
    */          
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        
        int sum = deepestLeavesSum(root);
        System.out.println("Deepest Leaf: " + Integer.toString(sum));
    }
    
    public static int deepestLeavesSum(TreeNode root) {
        ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
        int depth = maxDepth(root);
        getDeepestLeaf(root,ls,depth, 0);
        int sum = 0;
        
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i).val);
            sum = sum + ls.get(i).val;
        }
        return sum;
    }
    
    public static void getDeepestLeaf(TreeNode curr, ArrayList<TreeNode> ls, int depth, int currDepth) {
        
        if (curr.left != null || curr.right != null) {
            if (curr.left != null) {
                getDeepestLeaf(curr.left,ls,depth,currDepth+1);
                
            }
            if (curr.right != null) {
                getDeepestLeaf(curr.right,ls,depth,currDepth+1);
            }
            
        }
        else {
            //System.out.println(curr.val);
            if (currDepth == depth) {
                ls.add(curr);
            }
        }
    }
    
    public static int maxDepth(TreeNode node){
        if (node == null) {
            return -1;
        }
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
     
            /* use the larger one */
            if (lDepth > rDepth) {
                return(lDepth + 1); 
            }
            else {
                return(rDepth + 1);
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
 
