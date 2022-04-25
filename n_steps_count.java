/* problem: given that there are n steps on a set of stairs,
 and you can only ascend 1 or 2 steps at a time, how many
 different ways can you go up the stairs? (recursion tree problem)
*/

public class n_steps {
    public static int count;
    public static void main(String[] args) {
        int n = 5;
        ncount(n);
        System.out.println("Num. Steps: " + n);
        System.out.println("Count: " + Integer.toString(count));
        
        count = 0;
        
        n = 10;
        ncount(n);
        System.out.println("Num. Steps: " + n);
        System.out.println("Count: " + Integer.toString(count));
    }
    
    public static void ncount(int n) {
        if (n == 1) {
            count++;
        }
        else if (n == 2) {
            count+=2;
        }
        else {
            ncount(n-1);
            ncount(n-2);
            
        }
    }
}
