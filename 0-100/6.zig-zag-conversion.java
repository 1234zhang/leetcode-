/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */
import java.util.List;
import java.util.ArrayList;
class Solution {
    public String convert(String s, int numRows) {
       if(numRows == 1) return s;
       List<StringBuffer> cueList = new ArrayList<>();
       for (int i = 0; i < Math.min(s.length(),numRows); i++) {
            cueList.add(new StringBuffer());
       }
       
       int rowLine = 0;
       boolean isGoingDown = false;
       for (char c : s.toCharArray()) {
           cueList.get(rowLine).append(c);
           if(rowLine == 0 || rowLine == numRows - 1){
               isGoingDown = !isGoingDown;
           }
           rowLine += isGoingDown ? 1 : -1;
       }
       StringBuffer sb = new StringBuffer();
       for (StringBuffer var : cueList) {
           sb.append(var); 
       }
       return sb.toString();
    }
}

