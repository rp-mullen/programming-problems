// problem: given two axis-aligned recrangles whose coordinates are given by (x1,y1,x2,y2), where (x1,y1) is
// the lower-left coordinate and (x2,y2) is the upper-right coordinate of each rectangle, determine whether
// they overlap.

public class is_rectangle_overlap {
    public static void main(String[] args) {
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        
        System.out.println("Do R1 and R2 overlap?");
        System.out.println("Result: " + isRectangleOverlap(rec1,rec2));
    }    

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        // define intersection by overlap
        int dx, dy;
        
        // y-values
        if (rec2[1] > rec1[3]) {
            
            dy = rec1[3] - rec2[1];
        }
        else if (rec2[1] == rec1[3]) {
            dy = 0;
        }
        else {
            dy = rec2[3] - rec1[1];
        }
        
        // x-values
        if (rec2[0] > rec1[2]) {
            dx = rec1[2] - rec2[0];    
        }
        else if (rec2[0] == rec1[2]) {
            dx = 0;
        }
        else {
            dx = rec2[2] - rec1[0];
        }
        
        // positive intersection - true, else - false
        if (dx > 0 && dy > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
