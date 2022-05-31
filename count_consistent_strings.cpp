// problem: given a string of characters (allowed) and an array of strings (words), determine the number
// of consistent strings in words, where a string is consistent if all of its constituent characters
// are contained in (allowed)

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int countConsistentStrings(string allowed, vector<string>& words);
bool isConsistent(string w, string allowed);

int main() {
    string allowed = "ab";
    vector<string> words = {"ad","bd","aaab","baa","badab"};
    
    cout << "number of consistent strings: " << countConsistentStrings(allowed,words) << endl;
}

int countConsistentStrings(string allowed, vector<string>& words) {
    int numConsistent = 0;
    for (int i = 0; i < words.size(); i++) {
        if (isConsistent(words[i], allowed)) {
            numConsistent++;
        }
    }
    return numConsistent;
}
    
bool isConsistent(string w, string allowed) {
    for (int i = 0; i < w.size(); i++) {
        if(!(allowed.find(w[i]) != std::string::npos)) {
            return false;
        }
    }
    return true;
}
    
