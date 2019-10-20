import java.util.HashMap;

/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (29.33%)
 * Likes:    856
 * Dislikes: 173
 * Total Accepted:    188K
 * Total Submissions: 632.7K
 * Testcase Example:  '1'
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "A"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 28
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 701
 * Output: "ZY"
 * 
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        
        HashMap<Integer, Character> mapping = new HashMap<Integer, Character>();
        char litter = 'A';
        mapping.put(0, ' ');
        for (int i = 1; i <= 26; i++) {
            mapping.put(i, litter++);
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int flag = n;
            n = n / 26;
            if(flag % 26 == 0){
                sb.insert(0, mapping.get(26));
                n = n - 1;
            }else{
                sb.insert(0, mapping.get(flag % 26));
            }
        }
        return sb.toString().trim();
    }
}
// @lc code=end

