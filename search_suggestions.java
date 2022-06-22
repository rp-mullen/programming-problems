// problem: given a list of products and a specified search word, return at most three
// search suggestions (in products) using the typed portion of the search word as the lexicographical prefix.

import java.util.*;

public class search_suggestions {
    public static void main(String[] args) {
        
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        
        Solution S = new Solution();
        List<List<String>> res = S.suggestedProducts(products,searchWord);
        
        System.out.print("products: [ " );
        for (int i = 0; i < products.length; i++) {
            System.out.print(products[i] + " ");
        }
        System.out.print("]\n");
        
        System.out.println("search word: " + searchWord);
        
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<List<String>>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            str.append(searchWord.charAt(i));
            res.add(getProducts(products,str.toString()));
        }
        return res;
    }
    
    public List<String> getProducts(String[] products, String typed) {
        Arrays.sort(products, String.CASE_INSENSITIVE_ORDER);
        int limit = 3;
        int added = 0;
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < products.length; i++) {
            if (products[i].startsWith(typed)) {
                res.add(products[i]);
                added++;
                if (added == limit) {
                    break;
                }
            }
        }
        return res;
    }
}
