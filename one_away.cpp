// problem: given two strings, determine whether they are at most one edit apart
// edit => (deletion, insertion, replacement)

#include <iostream>
#include <cmath>

using namespace std;


bool oneAway(string s, string w) {
    int diff = w.size() - s.size();
    diff = abs(diff);
    
    if (diff > 1) {
        return false;
    }
    
    if (s.size() > w.size()) {
        for (int i = 0; i < w.size(); i++) {
            if (s[i] != w[i]) {
                diff++;
            }
        }
    }
    else {
        for (int j = 0; j < s.size(); j++) {
            if (s[j] != w[j]) {
                diff++;
            }
        }
    }
    
    return (diff <= 1);
}

int main() {
    cout << oneAway("pale","pal");
    cout << oneAway("pales","pale");
    cout << oneAway("pale","bale");
    cout << oneAway("pale","bake");

    return 0;
}
