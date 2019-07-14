/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */
class Solution {
    public static int lengthOfLastWord(String s) {
        String[] strSplit = s.split(" ");
        if(strSplit.length == 0){
            return 0;
        }
        return strSplit[strSplit.length-1].length();
    }
}

