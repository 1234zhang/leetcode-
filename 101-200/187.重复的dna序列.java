/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 *
 * https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (42.63%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    8.4K
 * Total Submissions: 19.7K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA
 * 中的重复序列有时会对研究非常有帮助。
 * 
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> findRepeatedDnaSequences(String s) {
        if("".equals(s)){ 
            return list;
        }
        int end = 10;
        int start = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(end <= s.length()){
            String temp = s.substring(start, end);
            if(map.containsKey(temp)){
                if(!list.contains(temp)){
                    list.add(temp);
                }
            }else{
                map.put(temp, 1);
            }
            end++;
            start++;
        }
        return list;
    }
}
// @lc code=end

