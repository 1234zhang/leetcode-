/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 *
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (27.86%)
 * Likes:    174
 * Dislikes: 0
 * Total Accepted:    17.8K
 * Total Submissions: 63.5K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * 输出：[]
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<Integer> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    int target = 0;
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0){
            return result;
        }
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int size = words.length;
        int len = words[0].length();
        for(int i = 0; i < len; i++){
            int left = i, right = i, count = 0;
            Map<String, Integer> contain = new HashMap<String, Integer>();
            while(right + len <= s.length()){
                String tmp = s.substring(right, right + len);
                contain.put(tmp, contain.getOrDefault(tmp, 0) + 1);
                right += len;
                count++;
                while(contain.getOrDefault(tmp, 0) > map.getOrDefault(tmp, 0)){
                    String flag = s.substring(left, left + len);
                    count--;
                    contain.put(flag, contain.getOrDefault(flag, 0) - 1);
                    left += len;      
                }
                if(count == size) result.add(left);
            }
        }
        return result;
    }
}
// @lc code=end

