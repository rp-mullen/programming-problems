// problem: given an integer array nums, return the number of triplets chosen from the array that can
// make triangles if we take them as side lengths of a triangle.

#include <iostream>
#include <vector>

using namespace std;

class Solution {
    public:
    int triangleNumber(vector<int>& nums) {
        int count = 0;
        for (int i = 0; i < nums.size() - 2; i++) {
            for (int j = i + 1; j < nums.size() - 1; j++) {
                for (int k = j + 1; k < nums.size(); k++) {
                    if (nums[i] + nums[j] > nums[k] && 
                        nums[i] + nums[k] > nums[j] && 
                        nums[j] + nums[k] > nums[i]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
};

int main() {
    Solution *S = new Solution();
    vector<int> nums = {2,2,3,4};
    int res = S->triangleNumber(nums);
    
    cout << "input: [";
    for (int i = 0; i < nums.size(); i++) {
        if (i != nums.size()-1) {
            cout << nums[i] << ", ";
        }
        else {
            cout << nums[i] << "]" << endl;
        }
    }
    
    cout << "result: " << res << endl;
    return 0;
}
