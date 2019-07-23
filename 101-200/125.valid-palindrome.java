/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        s = s.toLowerCase();
        String res = s.replaceAll("[^a-z0-9]", "");
        int min = (0 + res.length() - 1)/2;
        if(res.equals("")){
            return true;
        }
        if(res.length() == 1){
            return true;
        }
        for (int i = 0,j = res.length() - 1; i <= min; i++,j--) {
            if(res.charAt(i) != res.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

