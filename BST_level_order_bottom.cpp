// problem: given a binary tree, return the bottom-up level order traversal of its nodes' values.
// (i.e., from left to right, level by level from leaf to root). 

#include <iostream>
#include <vector>
#include <map>

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
    std::map<int,std::vector<int>> levels;
    std::vector<std::vector<int>> result;
    
    std::vector<std::vector<int>> levelOrderBottom(TreeNode* root) {
        if (root == NULL) {
            return result;
        }
        else {
            traverse(root,0);
            fill_nodes();
            
            std::cout << "Input Tree: " << std::endl;
            print_map(levels);
            std::cout << std::endl;
            
            std::cout << "Output: " << std::endl;
            print_levels(result);
            std::cout << std::endl;
            
            return result;
        }
    }
    
    void traverse(TreeNode *curr, int depth) {
        if (levels.find(depth) != levels.end()) {
            levels[depth].push_back(curr->val);    
        }
        else {
            levels.insert(std::pair<int,std::vector<int>>(depth, std::vector<int>()));
            levels[depth].push_back(curr->val);
        }
        
        if (curr->left != NULL) {
            
            traverse(curr->left,depth+1);
        }
        if (curr->right != NULL) {
            traverse(curr->right,depth+1);
        }
    }
    
    void print_levels(std::vector<std::vector<int>> v) {
        for (int i = 0; i < v.size(); i++) {
            for (int j = 0; j < v[i].size(); j++) {
                std::cout << v[i][j] << " ";    
            }
            std::cout << std::endl;
        }
    }
    
    void print_map(std::map<int,std::vector<int>> m) {
        for (int i = 0; i < m.size(); i++) {
            for (int j = 0; j < m[i].size(); j++) {
                std::cout << m[i][j] << " ";    
            }
            std::cout << std::endl;
        }
    }
    
    
    void fill_nodes() {
        for (int i = 0; i < levels.size(); i++) {
            result.push_back(levels[levels.size()-1-i]);
        }
    }

};

int main() {
    Solution *S = new Solution();
    
    TreeNode* root = new TreeNode(3);
    
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    
    root->right->left = new TreeNode(15);
    root->right->left = new TreeNode(7);
    
    S->levelOrderBottom(root);
    
    
}
