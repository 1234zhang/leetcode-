/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.50%)
 * Likes:    502
 * Dislikes: 0
 * Total Accepted:    59.6K
 * Total Submissions: 115.6K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    List<String> result = new ArrayList<>();
    char[] nums;
    public List<String> letterCombinations(String digits) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        nums = digits.toCharArray();
        if("".equals(digits)){
            return result;
        }
        for(int i = 0; i < map.get(nums[0] - '0').length(); i++){
            String str = map.get(nums[0] - '0');
            helper("" + str.charAt(i), 1);
        }
        return result;
    }
    public void helper(String target, int position){
        if(position == nums.length){
            result.add(target);
            return;
        }
        String str = map.get(nums[position] - '0');
        for(int i = 0; i < str.length(); i++){
            helper(target + str.charAt(i), position + 1);
        }
    }
}
// @lc code=end

