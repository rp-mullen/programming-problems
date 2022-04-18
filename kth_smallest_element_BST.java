// problem: given a binary search tree (BST), find the kth smallest value in the tree.

import java.util.*;

public class kth_smallest_element_BST {
    
    public static void main(String[] args) {
        
        //   example tree:
        /*
                  3 
                /   \
              1       4
                 \
                  2
        */
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        
        int k = 1;
        
        kthSmallest(root, k);
        
    }
    
    // sort listified BST and retun kth value
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        
        lst = listify(root,lst);
        Collections.sort(lst);
        
        return lst.get(k-1);
    }
    
    // convert BST into ArrayList
    public static ArrayList<Integer> listify(TreeNode root, ArrayList<Integer> lst) {
        if (root == null) {
            return lst;
        }
        else {
            lst.add(root.val);
            listify(root.left, lst);
            listify(root.right,lst);
        }
        return lst;
    }
}


 // Definition for a binary tree node.
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
 
