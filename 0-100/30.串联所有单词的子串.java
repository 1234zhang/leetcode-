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
    HashSet<String> set = new HashSet<>();
    int target = 0;
    public List<Integer> findSubstring(String s, String[] words) {
        if("".equals(s) || words.length == 0){
            return result;
        }
        helper(words, 0);
        for(int i = 0; i < s.length(); i++){
            if(i + target <= s.length() && set.contains(s.substring(i, i + target))){
                result.add(i);
            }
        }
        return result;
    }
    public void helper(String[] words, int flag){
        if(flag == words.length){
            StringBuffer sb = new StringBuffer();
            for(String str : words){
                sb.append(str);
            }
            target = sb.toString().length();
            set.add(sb.toString());
            return;
        }
        HashSet<String> hash = new HashSet<>();
        for(int i = flag; i < words.length; i++){
            if(i == flag || !hash.contains(words[i])){
                hash.add(words[i]);
                swap(words, i, flag);
                helper(words, flag + 1);
                swap(words, i, flag);
            }
        }
    }
    public void swap(String[] words, int start, int end){
        String tmp = words[start];
        words[start] = words[end];
        words[end] = tmp;
    }
}
// @lc code=end

