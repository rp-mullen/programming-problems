// problem: given an unsigned 32-bit int, return the number of 1-bits it contains.
#include<iostream>

class Solution {
public:
    int res = 0;
    int hammingWeight(uint32_t n) {
        while (n != 0) {
            if (n % 2 == 1) {
                res++;
            }
            n = n/2;
        }
        return res;
    }    
};

// driver code
int main() {
  Solution *S = new Solution();
  uint32_t n = 00000000000000000000000000001011; // 11
  
  std::cout << S->hammingWeight(n) << std::endl;
}
