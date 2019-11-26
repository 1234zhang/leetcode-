/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.63%)
 * Likes:    1483
 * Dislikes: 0
 * Total Accepted:    143.7K
 * Total Submissions: 519.4K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public String longestPalindrome(String s) {
        if("".equals(s) || s.length() == 1){
            return s;
        }
        int max = Integer.MIN_VALUE;
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for(int i = 0; i < s.length(); i++){
            int flag = s.length() - 1;
            while(flag >= i){
                if(judge(s.substring(i, flag + 1))){
                    int len = flag + 1 - i;
                    map.put(len, s.substring(i, flag + 1));
                    max = Math.max(max, len);
                    break;
                }
                flag--;
            }
        }
        return map.get(max);
    }
    public boolean judge(String s){
        if(s.length() == 1){
            return true;
        }
        int len = s.length() / 2;
        for(int i = 0; i <= len; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

