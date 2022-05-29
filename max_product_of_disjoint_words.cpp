#include <algorithm>

// problem: given an array of words, return the maximum product of two words that have no common letters

class Solution {
public:
    int maxProduct(vector<string>& words) {
        int ans = 0;
        int tmpMax;
        for (int i = 0; i < words.size()-1; i++) {
            for (int j = 1; j < words.size(); j++) {
                if (noCommonLetters(words[i],words[j])) {
                    tmpMax = words[i].size() * words[j].size();
                    ans = std::max(tmpMax,ans);
                }
            }
        }
        return ans;
    }
    
    bool noCommonLetters(string w1, string w2) {
        vector<char> ch;
        
        for (int i = 0; i < w1.size(); i++) {
            if (std::count(ch.begin(), ch.end(), w1[i]) == 0) {
                ch.push_back(w1[i]);
            }
        }
        for (int j = 0; j < w2.size(); j++) {
            if (std::count(ch.begin(), ch.end(), w2[j])) {
                return false;
            }
        }
        
        return true;
        
        
    }
};
