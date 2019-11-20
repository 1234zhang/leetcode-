/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (41.99%)
 * Likes:    1234
 * Dislikes: 50
 * Total Accepted:    189.7K
 * Total Submissions: 435.6K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = helper(s, 0);
        return result;
    }
    public List<List<String>> helper(String s, int start){
        if(start == s.length()){
            List<List<String>> result = new ArrayList<>();
            List<String> ans = new ArrayList<String>();
            result.add(ans);
            return result;
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s.substring(start, i + 1))){
                String str = s.substring(start, i + 1);
                for(List<String> l : helper(s, i + 1)){
                    l.add(0, str);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s){
        int len = s.length() - 1;
        int i = 0;
        while(len > i){
            if(s.charAt(i) != s.charAt(len)){
                return false;
            }
            len--;
            i++;
        }
        return true;
    }
}
// @lc code=end

