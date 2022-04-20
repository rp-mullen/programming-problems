/*
problem: given an array of 0's and 1's and an integer k, determine whether the spacing between each 1 in the array is at least k. 
*/

#include <iostream>
#include <vector>

bool kLengthApart(std::vector<int>& nums, int k);

bool kLengthApart(std::vector<int>& nums, int k) {
    int dist = 0;
    bool first = true;
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] == 1 && first) {
            first = false;
        }
        else if (nums[i] == 1 && !first) {
            std::cout << dist;
            if (dist < k) {
                return false;
            }
            dist = 0;
        }
        else {
            dist++;
        }
    }
    return true;
}

// test code
void driver() {
    std::vector<int> nums = {1,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1};
    int k = 2;
    
    if (kLengthApart(nums,k)) {
        std::cout << "True";
    }
}

int main() {
    driver();
    return 0;
}
