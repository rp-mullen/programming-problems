//problem: write a method that determiens whether a string (a) is a predecessor of string (b).
// one string is a predecessor of another if and only if exactly one character can be deleted from
// (b) in order for (b) to be equal to (a).
#include <iostream>
#include <vector>

using namespace std;

string removeChar(string a, int i);
bool isPredecessor(string a, string b);

bool isPredecessor(string a, string b) {
    bool res = false;
    if (b.find(a) != std::string::npos) {
        for (int i = 0; i < b.size(); i++) {
            if (a.find(b[i]) == std::string::npos) {
                if (removeChar(b,i) == a) {
                    res = true;
                }
            }
        }
    }
    else {
        res = false;
    }
    
    return res;
}
    
string removeChar(string a, int i) {
    string res;
    for (int j = 0; j < a.size(); j++) {
        if (j != i) {
            res += a[j];
        }
    }
    return res;
}


int main() {
    cout << isPredecessor("abc","dabc") << endl;
    cout << isPredecessor("ab","abc") << endl;
    return 0;
}
