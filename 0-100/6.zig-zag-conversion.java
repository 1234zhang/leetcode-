/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */
class Solution {
    public String convert(String s, int numRows) {
        if(s.equals("") && s.length() <= 1){
            return s;
        }
        if(numRows == 1){
            return s;
        }
        double n = Math.ceil(s.length()/(2 * (double)numRows - 2));
        
        String[] subStr = new String[(int)n];
        for (int i = 0; i < n; i++) {
            if(s.length() < (i + 1) * (2 * numRows - 2)){
                subStr[i] = s.substring(i*(2 * numRows - 2), (i + 1) * (2 * numRows - 2) + 1);
            }else{
                subStr[i] = s.substring(i * (2 * numRows - 2),s.length()); 
            }
        }
        for (int i = 0; i < subStr[0].length(); i++) {
            
        }
        return null;
    }
}

