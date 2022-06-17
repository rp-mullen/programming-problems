// problem: given a string s, count the number of homogeneous substrings of s

class Solution {
    public int countHomogenous(String s) {
        int res = 0;
        List<String> subs = getHomogeneousSubstrings(s);
        System.out.println("subs size: " + Integer.toString(subs.size()));
        for (int i = 0; i < subs.size(); i++) {
            System.out.println(subs.get(i).length());
            res += kChooseN(subs.get(i).length(),2);
            res += subs.get(i).length();
        }
        int mod = 1000000007;
        return res % mod ;
    }
    
    public int kChooseN(int n,int k) {
        
         int dp[][] = new int[n+1][k+1];
           int i,j, check;
         
         for (i=0 ; i<=n ;i++)
         {
             check = i>k ? k : i ;
             
             for(j=0 ; j<=check ;j++)
              {
                  if(i==0 || j==0)
                   dp[i][j]=1;
                   
                   else
                   dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
              }
         }
         
         return dp[n][k];
     
    }
    
    public List<String> getHomogeneousSubstrings(String s) {
        ArrayList<String> subs = new ArrayList<String>();
        
        int idx = 0;
        char currChar='0';
        char prevChar='0';
        
        StringBuilder str = new StringBuilder();
        while (idx < s.length()) {
            if (idx == 0) {
                currChar = s.charAt(0);
                prevChar = s.charAt(0);
            }
            
            prevChar = currChar;
            currChar = s.charAt(idx);
            
            
            if (prevChar != currChar) {
                subs.add(str.toString());
                str = new StringBuilder();
                str.append(currChar);
                
            }
            else {
                str.append(currChar); 
            }
            idx++;
        }
        subs.add(str.toString());
        
        return subs;
    }
}
