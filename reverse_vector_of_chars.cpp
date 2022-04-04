// problem: given a vector of characters, reverse the vector in-place with minimal extra space complexity.

#include <iostream>
#include <vector>

void reverseString(std::vector<char>& s) {
        int origSize = s.size();
        
        for (int i = s.size()-1; i >= 0; i--) {
            s.push_back(s[i]);
        }
        
        for (int i = 0; i < origSize; i++) {
            s[i] = s[origSize+i];
        }
        s[origSize] = s[s.size()];
        
        
        for (int i = 0; i < origSize; i++) {
            s.pop_back();
        }
        
    }

void print(std::vector<char>& s) {
    for (int i = 0; i < s.size(); i++) {
        std::cout << s[i];
    }
    std::cout << std::endl;
}


int main()
{
    std::vector<char> s{'H','e','l','l','o',' ','W','o','r','l','d','!'};
    std::cout << "Input: ";
    print(s);
    
    std::cout << "Output: ";
    reverseString(s);
    print(s);
}
