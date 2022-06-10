
// problem: given a string s, determine the length of its longest substring containing no repeating characters

#include <iostream>
#include <vector>

using namespace std;

int lengthOfLongestSubstring(string s) {
    vector<int> chars(128);

    int left = 0;
    int right = 0;

    int res = 0;
    
    // increment by right and decrement by left on any repeating characters, compare with max to retain max length
    while (right < s.length()) {
        char r = s[right];
        chars[r]++;

        while (chars[r] > 1) {
            char l = s[left];
            chars[l]--;
            left++;
        }

        res = max(res, right - left + 1);

        right++;
    }

    return res;
}

int main() {
    cout << lengthOfLongestSubstring("abcabcbb") << endl; 
}
