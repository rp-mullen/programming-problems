// given an integer x, calculate the integer part of its square root without using standard math library operations 
// solution: babylonian algorithm

public class sqrtx {
    public static void main(String[] args) {
        int x = 32456321;
        System.out.println("Number: " + x);
        System.out.println("Sqrt(x): " + mySqrt(x));
    }
    
    public static int mySqrt(int x) {
        
        // if S is an overestimate, S/2 is an underestimate.
        // So the average of the two gives a better approximation.
        if (x == 1) {
            return 1;
        }
        else {
            // create initial overestimate
            double guess_divisor = 1.5;
            double guess = x/guess_divisor;
            
            // error tolerance
            int tol = 1000;
            
            // algorithm
            for (int i = 0; i < tol; i++) {
                guess = ((x/guess) + guess)/2; 
            }
            return (int)Math.floor(guess);
        }
    }
}
