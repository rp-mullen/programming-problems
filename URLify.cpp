// problem: given a string, replace all of its spaces with "%20"
#include <iostream>
#include <string>

using namespace std;

string URLify(string s) {
    
    string res = "";
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == ' ') {
             res += "%20";
        }
        else {
            res += s[i];
        }
    }
    return res;
}

int main() {
    
    string s = "here is a test string";
    cout << "Input: " << s << endl;
    cout << "Result: " << URLify(s) << endl;
    
    return 0;
}
