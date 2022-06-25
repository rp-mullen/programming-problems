class Solution {
    public String solveEquation(String equation) {
        int[] LHS = new int[2];
        int[] RHS = new int[2];
        
        boolean beforeEquals = true;
        int sign = 1;
        
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '=') {
                beforeEquals = false;
                i++;
            }
            
            if (beforeEquals) {
               if (equation.charAt(i) == '-') {
                   sign = -1;
               } 
               else if (equation.charAt(i) == '+') {
                   sign = 1;
               }
                
                if (equation.charAt(i) == 'x' && i > 0) {
                    if (isNumber(equation.charAt(i-1))) {
                        LHS[0] += Integer.parseInt(String.valueOf(equation.charAt(i-1)))*sign;    
                    }
                    else {
                        LHS[0] += sign;
                    }
                }
                else if (equation.charAt(i) == 'x' && i == 0) {
                    LHS[0] += sign;
                }
                
                if (i > 0 && i < equation.length()-1) {
                    if (isNumber(equation.charAt(i)) && isOperation(equation.charAt(i+1)) && isOperation(equation.charAt(i-1))) {
                        System.out.println("constant found: " + Integer.toString(sign) + "*" + equation.charAt(i));
                        LHS[1] += Integer.parseInt(String.valueOf(equation.charAt(i)))*sign;
                    }
                    else if (isNumber(equation.charAt(i)) && equation.charAt(i+1) == 'x') {
                        LHS[0] += Integer.parseInt(String.valueOf(equation.charAt(i)))*sign;
                    }
                }
                
                if (i == 0 && equation.charAt)
                else if {
                    
                }
                
                
            }
            else {
                sign = 1;
                
                if (equation.charAt(i) == '-') {
                   sign = -1;
               } 
               else if (equation.charAt(i) == '+') {
                   sign = 1;
               }
                
                if (equation.charAt(i) == 'x' && i > 0) {
                    if (isNumber(equation.charAt(i-1))) {
                        RHS[0] += Integer.parseInt(String.valueOf(equation.charAt(i-1)))*sign;    
                    }
                    else {
                        RHS[0] += sign;
                    }
                }
                else if (equation.charAt(i) == 'x' && i == 0) {
                    RHS[0] += sign;
                }
                
                
                if (i > 0 && i < equation.length()-1) {
                    if (isNumber(equation.charAt(i)) && isOperation(equation.charAt(i+1)) && isOperation(equation.charAt(i-1))) {
                        System.out.println("constant found: " + Integer.toString(sign) + "*" + equation.charAt(i));
                        RHS[1] += Integer.parseInt(String.valueOf(equation.charAt(i)))*sign;
                    }
                }
            }
        
        }
        
        System.out.println("LHS factors: " + Integer.toString(LHS[0]));
        System.out.println("RHS factors: " + Integer.toString(RHS[0]));
        
        System.out.println("");
                        
        System.out.println("LHS constants: " + Integer.toString(LHS[1]));
        System.out.println("RHS constants: " + Integer.toString(RHS[1]));
                        
        return "x=0";
        
        
    }
    
    
    public boolean isNumber(Character ch) {
        String nums = "0123456789";
        return (nums.contains(String.valueOf(ch)));
    }
                        
    public boolean isOperation(Character ch) {
        String ops = "+-";
        return (ops.contains(String.valueOf(ch)));
    }
}
