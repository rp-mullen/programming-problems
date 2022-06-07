// problem: given an array nums of integers where one element A is repeated N times, where
// nums.size() = 2*N, return the element A.

#include <iostream>
#include <map>
#include <vector>

using namespace std;

int repeatedNTimes(vector<int>& nums);

int main() {
    vector<int> v = {5,1,5,2,5,3,5,4};
    cout << repeatedNTimes(v) << endl;
}

int repeatedNTimes(vector<int>& nums) {
    map<int,int> map;
    int el;
    for (int i = 0; i < nums.size(); i++) {
        map[nums[i]]++;
    }
        
    for (int j = 0; j < nums.size(); j++) {
        if(map[nums[j]] == nums.size() / 2) {
            el = nums[j];
        }
    }
    return el;
}
