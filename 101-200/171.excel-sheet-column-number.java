/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (52.02%)
 * Likes:    660
 * Dislikes: 124
 * Total Accepted:    244K
 * Total Submissions: 464.3K
 * Testcase Example:  '"A"'
 *
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "A"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "AB"
 * Output: 28
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "ZY"
 * Output: 701
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int titleToNumber(String s) {
        Map< Character, Integer> mapping = new HashMap<Character, Integer>();
        char begin = 'A';
        for (int i = 1; i <= 26; i++) {
            mapping.put(begin++, i);
        }
        char[] chars = s.toCharArray();
        int result = 0;
        int len = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            result += mapping.get(chars[i]) * Math.pow(26, len--);
        }
        return result;
    }
}
// @lc code=end

