// problem: given an int n, convert n to its representation in base (-2). slightly more challenging than regular conversion because
// the remainder can be negative.

public class convert_negative_base_2 {
    public static String baseNeg2(int n) {
        
      if (n == 0) {
            return "0";
        }
        else {
        
            String res="";
            int x = n;
            while (x!=0) {
                int remainder = x % -2;
                x /= -2;
            
                if (remainder < 0) {
                    remainder += 2;
                    x += 1;
                }
            
                res = Integer.toString(remainder) + res;                
            }
            return res;
        }
    }
    
    public static void main(String[] args) {
        int n = 24;
        System.out.println("Input: " + Integer.toString(n));
        System.out.println("Output: " + baseNeg2(n));
    }
}
