/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("") || s.length() <= 1){
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expendAroundCenter(s, i, i);
            int len2 = expendAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end + 1);
    }
    public int expendAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right ++;
        }
        return right - left - 1;
    }
}
// 这道题是看的答案，但是解题思路很简单，遍历这个字符串，每遍历到一个字符就
// 就寻找以这个字符为中心的回文字符串。
