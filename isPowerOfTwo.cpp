// problem: given an integer n, determine whether n is a power of two.
// i.e. n = 2^(x) for some integer x.

#include <iostream>
#include <cmath>

bool isPowerOfTwo(int n);
int twoMag(int n);

// checks whether two raised to the power of the twoMag output is equal to the input.
bool isPowerOfTwo(int n) 
    {
        return (pow(2,twoMag(n)) == n);
    }

// returns the two-base exponent of the number    
int twoMag(int n) 
{
    if (n / 2 == 0) 
    {
        return 0;
    }
    else 
    {
        return 1 + twoMag(n / 2);
    }
}


int main() 
{
    srand(time(NULL));
    std::cout << "Input --------------- Output  " << std::endl;
    std::string t;
    for (int i = 0; i < 50; i++) {
        int n = rand()%100;
        
        if (isPowerOfTwo(n)) 
        {
            t = "true";
        }
        else 
        {
            t = "false";
        }
        
        std::cout << n << " --------------- " << t << std::endl;
    }
    
}
