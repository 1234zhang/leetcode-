/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (32.10%)
 * Likes:    821
 * Dislikes: 348
 * Total Accepted:    155.7K
 * Total Submissions: 476.8K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s.equals("")){
            return result;
        }        
        backtracking(0, "", 4, s, s.length());
        return result;
    }

    public void backtracking(int i, String temp, int flag , String s, int len){
        if(flag == 0 && i == len){
            result.add(temp.substring(0, temp.length() - 1));
            return;
        }
        if(flag < 0) return;
        for (int j = i; j < i + 3; j++) {
            if(j < len){
                String sub = s.substring(i, j + 1);
                if(isValid(sub)){
                    backtracking(j + 1, temp + sub + ".", flag - 1, s, len);
                }
                
            }
        }
    }
    public boolean isValid(String temp){
        if(temp.length() > 3){
            return false;
        }
        return temp.charAt(0) == '0' ? temp.length() == 1 : Integer.parseInt(temp) <= 255;
    }
}
// @lc code=end

