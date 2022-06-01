// problem: (cracking the coding interview, 1.1) determine whether a string is made of unique characters. try this without using any additional data structures.

#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

//  no additional data structures
bool isUniqueOne(string s) {
    for (int i = 0; i < s.size(); i++) {
        for (int j = 0; j < s.size(); j++) {
            if (s[i] == s[j] && i != j) {
                return false;
            }
        }
    }
    return true;
}

// hash map implementation
bool isUniqueTwo(string s) {
    map<char,int> mp;
    for (int i = 0; i < s.size(); i++) {
        if (mp.count(s[i]) == 0) {
            mp[s[i]] = 1;
        }
        else {
            return false;
        }
    }
    return true;
}

void printSolution(vector<string> v) {
    for (int i = 0; i < v.size(); i++) {
        string res;
        if (isUniqueTwo(v[i])) {
            res = "True";
        }
        else {
            res = "False";
        }
        
        cout << "Input: " << v[i] << " " << res << endl;
    }
}

int main() {
    vector<string> tests = {"abcd","addc","aaa","a","skjhgfrt"};
    printSolution(tests);
    
}
