// problem: given an integer n, generate a string of length n whose characters appear an odd number of times.

import java.util.*;

public class generate_odd_char_string {
    public static void main(String[] args) {
        int n = 10;
        String s = generateTheString(n);
        System.out.println("input (n): " + n);
        System.out.println("result: " + s);
    }

    public static String generateTheString(int n) {
        StringBuilder res = new StringBuilder();
        
        // if even, print 'a' n-1 times and 'b' 1 time
        if (n % 2 == 0) {
            for (int i = 0; i < n-1; i++) {
                res.append("a");
            }
            res.append("b");
        }
        
        // if already odd, just print a, n times
        else {
            for (int i = 0; i < n; i++) {
                res.append("a");
            }
        }
        
        return res.toString();
    }
}
