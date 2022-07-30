/*
problem: given a binary tree, return the number of nodes whose subtrees have an average value equal to the value
of the root node.
*/

import java.util.*;

public class tree_node_averages {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        
        root.right.right = new TreeNode(6);
        
        
        /*      INPUT TREE
                    4
                  /   \
                 8     5
               /  \     \
              0    1     6
        */
        
        // expected output: 5
        
        int result = Solution.averageOfSubtree(root);
        System.out.println(result);
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
 
class Solution {

    public static int result = 0;
    
    public static int averageOfSubtree(TreeNode root) {
        traverseTree(root);
        return result;
    }
    
    public static void traverseTree(TreeNode curr) {
        if (curr != null) {
            List<Integer> L = new ArrayList<>();
            calculateAverageNode(curr,L);
            if (mean(L) == curr.val) {
                result++;
            }
            traverseTree(curr.left);
            traverseTree(curr.right);
        }
    }
    
    public static void calculateAverageNode(TreeNode curr, List<Integer> vals) {
        if (curr != null) {
            vals.add(curr.val);
            calculateAverageNode(curr.left,vals);
            calculateAverageNode(curr.right,vals);
        }
    }
    
    public static int mean(List<Integer> L) {
        int res = 0;
        for (int i = 0; i < L.size(); i++) {
            res += L.get(i);
        }
        res = res / L.size();
        return res;
    }
}
