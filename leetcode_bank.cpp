/*
Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
*/

#include <iostream>

using namespace std;

class Solution {
public:
    int totalMoney(int n) {
        int total = 0;  // total amount
        int week = 0;   // weekly amount
        int mon = 0;    // monday amount
        
        for (int i = 0; i < n; i++) {
            week++;
            if (i % 7 == 0) {
                mon++;
                week = mon;
            }
            total += week;
            
        }
        
        return total;
    }
};

int main() {
    Solution *S = new Solution();
    int n = 10;
    
    cout << "input: " << n << " days" << endl;
    cout << "money: $" << S->totalMoney(n) << endl; 
    return 0;
}
