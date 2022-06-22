// problem: in an array of integers, exactly two elements occur only once. return those two elements in linear
// time with constant extra space.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<int> v;
        
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums[i+1] == nums[i]) {
                i++;
            }
            else {
                v.push_back(nums[i]);    
            }
        }
        
        if (nums[nums.size()-1] != nums[nums.size()-2]) {
            v.push_back(nums[nums.size()-1]);
        }
        
        return v;
        
    }
};

int main() {
    vector<int> arr = {1,2,1,3,2,5} ;  
    
    Solution *S = new Solution();
    vector<int> res = S->singleNumber(arr);
    
    cout << "Input: [";
    for (int i = 0; i < arr.size(); i++) {
        if (i != arr.size()-1) {
            cout << arr[i] << ", ";
        }
        else {
            cout << arr[i] << "]\n";
        }
    }
    
    cout << "Output: [" << res[0] << ", " << res[1] << "]\n";
    
    
    return 0;
}
