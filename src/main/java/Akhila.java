// class Solution {
//     public String longestPalindrome(String s) {

//     }


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solutionx {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        Solutionx a  = new Solutionx();
        a.longestPalindrome("aba");
        String[] characters = "2*4*3*".split("\\*");
        List<Integer> list  = new ArrayList<>(Arrays.asList(1,2,3));
        list.remove(list.size()-1);
    }}