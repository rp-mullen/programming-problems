#include <iostream>
#include <vector>

using namespace std;

class AuthenticationManager {
public:
    int timeToLive;
    int currentTime = 0;
    vector<pair<string,int>> tokens;
    
    AuthenticationManager(int timeToLive) {
        this->timeToLive = timeToLive;
    }
    
    void generate(string tokenId) { 
        tokens.push_back(pair<string,int>{tokenId,currentTime+timeToLive});
        currentTime++;
    }
    
    
    void renew(string tokenId) {
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens[i].first == tokenId) {
                if (tokens[i].second > currentTime) {
                    tokens[i].second = currentTime + timeToLive;
                }
            }    
        }
        currentTime++;
        
    }
    
    int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens[i].second > currentTime) {
                res++;
            }
        }
        currentTime++;
        return res;
    }
    
    void passTime(int t) {
        currentTime += t;
    }
    
    void printTokens() {
        cout << "tokens: ";
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens[i].second > currentTime) {
                cout << "{" << tokens[i].first << ", " << tokens[i].second << "} ";
            }
        }
        cout << endl;
        currentTime++;
    }
    
    void printTime() {
        cout << "time: " << currentTime << endl;
    }
};

int main() {
    AuthenticationManager *M = new AuthenticationManager(5);
    M->generate("aaa");
    M->passTime(2);
    M->generate("bbb");
    
    M->printTime();
    M->printTokens();
    
    M->renew("aaa");
    
    M->generate("ccc");
    
    M->passTime(2);
    
    M->printTime();
    M->printTokens();
    
    
    
    
    return 0;
}
