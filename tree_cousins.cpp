// problem: given a binary tree, determine whether two unique nodes in the tree x, y are cousins --
// that is, if they share the same depth but not the same parent.

#include<iostream>
#include<vector>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
 
class Solution {
public:
    std::vector<int> depths;
    std::vector<int> parents;
    bool isCousins(TreeNode* root, int x, int y) {
        getDepth(root,x,0,0);
        getDepth(root,y,0,0);
        
        return (depths[0] == depths[1] && parents[0] != parents[1]);
    }
    
    void getDepth(TreeNode* curr, int n,int depth=0, int parent = 0) {
        if (curr->val == n) {
            
            depths.push_back(depth);
            parents.push_back(parent);
        }
        else {
            depth++;
            if (curr->left != NULL) {
                getDepth(curr->left, n, depth, curr->val);
            }
            if (curr->right != NULL) {
                getDepth(curr->right, n, depth,curr->val);
            }
        }

    }
};

int main() {
    Solution *S = new Solution();

    /*          TEST TREE
                    1
                /       \
               2         3
             /   \         \
            4     5         6
           /                 \
          7                   8
    
    */          
    TreeNode* root = new TreeNode(1);
        
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
        
    root->right->right = new TreeNode(6);
    root->right->right->right = new TreeNode(8);
        
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->left->left->left = new TreeNode(7);
        
    std::cout << "Nodes 4 and 6 are cousins: ";
    if (S->isCousins(root,4,6)) {
        std::cout << "True" << std::endl;
    }
    else {
        std::cout << "False" << std::endl;
    }
    
