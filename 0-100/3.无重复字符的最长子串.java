/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (32.02%)
 * Likes:    2739
 * Dislikes: 0
 * Total Accepted:    276.6K
 * Total Submissions: 863.3K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            while(i < s.length() && !map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                i++;
            }
            if(i < s.length()){
                i = map.get(s.charAt(i));
            }
            max = Math.max(map.size(), max);
        }
        return max;
    }
}
// @lc code=end

