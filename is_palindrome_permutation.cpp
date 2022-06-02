// problem: given a string s, determine whether s is a permutation of a palindrome.

#include <iostream>
#include <map>

using namespace std;

// solution
bool isPalindromePermutation(string s) {
    // at most one character can have an odd count
    int oddCount = 0;
    
    map<char,int> mp;
    for (int i = 0; i < s.size(); i++) {
        mp[s[i]]++;
    }
    for (map<char,int>::iterator it = mp.begin(); it != mp.end(); ++it) {
        if (it->second % 2 != 0) {
            oddCount++;
        }
    }
    if (oddCount > 1) {
        return false;
    }
    return true;
}

// driver code
int main() {
    
    cout << isPalindromePermutation("tacocat") << endl;
    cout << isPalindromePermutation("tactcoapapa") << endl;
    cout << isPalindromePermutation("aaa") << endl;
    cout << isPalindromePermutation("abc") << endl;
    
    return 0;
}
