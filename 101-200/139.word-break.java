/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (36.07%)
 * Likes:    2950
 * Dislikes: 163
 * Total Accepted:    416.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<String> dic;
    int len = 0;
    public boolean wordBreak(String s, List<String> wordDict) {
        dic = wordDict;
        len = s.length();
        return helper(s);
    }
    public boolean helper(String s){
        if(s.equals("")){
            return true;
        }
        if(dic.contains(s)){
            return true;
        }
        for(int i = s.length(); i >= 0; i--){
            String tmp = s.substring(i, s.length());
            if(dic.contains(tmp)){
                return helper(s.substring(0, i));
            }
        }
        return false;
    }
}
// @lc code=end
