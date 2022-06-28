//problem: given an array of integers and an integer (k), return the number of unique pairs whose
// difference is equal to (k).

#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        int res = 0;
        map<int,int> mp;
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (nums[j] - nums[i] == k && mp[nums[i]] == 0 && i!=j) {
                    mp[nums[i]]++;
                    res++;
                }
            }
        }
        return res;
    }
};

int main() {
    vector<int> nums = {3,1,4,1,5,2};
    int k = 2;
    
    cout << "input: [";
    for (int i = 0; i < nums.size(); i++) {
        if (i != nums.size()-1) {
            cout << nums[i] << ", ";
        }
        else {
            cout << nums[i] << "]\t";
        }
    }
    
    cout << "k = " << k << endl;
    
    Solution *S = new Solution();
    cout << "pairs found: " << S->findPairs(nums,k) << endl;
    return 0;
}
