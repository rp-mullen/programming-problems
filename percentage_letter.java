// problem: given a string (s) and a character (letter), determine what percentage of (s) is made up
// of (letter).

public class percentage_letter {
    
    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        
        percentageLetter(s,letter);
    }

    public static int percentageLetter(String s, char letter) {
            int charCount = 0;
            int size = s.length();
            int res;
            
            
            for (int i = 0; i < size; i++) {
                if (s.charAt(i) == letter) {
                    charCount++;
                }
            }
            res = (100*charCount) / size;
            System.out.println(letter + " is " + Integer.toString(res) + " percent of " + s);
            return res;
    }
}
