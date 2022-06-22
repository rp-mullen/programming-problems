// problem: given an array of numbers in which only one element has over a 25% occurence, find and return that element.

#include <iostream>
#include <vector>
#include <map>

using namespace std;

// the solution will always be the most common element.
class Solution {
public:

    int findSpecialInteger(vector<int>& arr) {
        map<int,int> mp;
        int size = arr.size();
        
        for (int i = 0; i < arr.size(); i++) {
            mp[arr[i]]++;
        }
                
        int res = mp.begin()->first;
        
        for (map<int,int>::iterator it = ++mp.begin(); it != mp.end(); ++it) {
            if (mp[it->first] > mp[res]) {
                res = it->first;
            }         
        }
        
        return res;
        
    }
};

int main() {
    vector<int> arr = {1,2,2,6,6,6,6,7,10};
    
    cout << "Input: [";
    for (int i = 0; i < arr.size(); i++) {
        if (i != arr.size()-1) {
            cout << arr[i] << ", ";
        }
        else {
            cout << arr[i] << "]" << endl;
        }
    }
    
    Solution *S = new Solution();
    cout << "Output: " << S->findSpecialInteger(arr) << endl;
    
    return 0;
}
