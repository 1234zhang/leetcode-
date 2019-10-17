/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.66%)
 * Likes:    1741
 * Dislikes: 1984
 * Total Accepted:    302.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars[0] == '0') return 0;
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = cur;
            if(chars[i] == '0'){
                if(chars[i - 1] == '1' || chars[i - 1] == '2'){
                    cur = pre;
                }else{
                    return 0;
                }
            }else{
                if(chars[i - 1] == '1'){
                    cur = cur + pre;
                }
                else if(chars[i - 1] == '2' && (chars[i] >= '1' && chars[i] <= '6')){
                    cur = cur + pre;
                }
            }
            pre = temp;
        }
        return cur;
    }
}
// @lc code=end

