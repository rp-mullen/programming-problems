// problem: given a string s comprised of only characters 'a' and 'b', determine the minimum number of palindrome subsequence deletions
// needed to produce an empty string from s.

#include <iostream>
#include <string>

using namespace std;

int main() {
    string s1 = "abbaabbabbab";
    string s2 = "abba";
    
    // not a palindrome 
    cout << removePalindromeSub(s1) << endl;
    
    // palindrome
    cout << removePalindromeSub(s2) << endl;
}


// solution: since s contains 'a' and 'b' and subsequences do not need to be contiguous, the minimum number of
// deletions will always be 1 if s is already a palindrome, or 2 if not, as all 'a's and all 'b's can each be deleted
// in a single step.
int removePalindromeSub(string s) {
    int steps = 0;
    
    if (isPalindrome(s)) {
        return 1;
    }
    else {
        return 2;    
    }
        
}
    
bool isPalindrome(string s) {
    for (int i = 0; i < s.size(); i++) {
        if (s[i] != s[s.size()-1-i]) {
            return false;
        }
    }
    return true;
}
