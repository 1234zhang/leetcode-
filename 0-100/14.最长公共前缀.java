/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (35.36%)
 * Likes:    782
 * Dislikes: 0
 * Total Accepted:    152.3K
 * Total Submissions: 430.3K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        return helper(strs, 0, strs.length - 1);
    }
    public String helper(String[] str, int left, int right){
        if(left == right){
            return str[left];
        }
        int mid = (left + right) / 2;
        String leftString = helper(str, left, mid);
        String rightString = helper(str, mid + 1, right);
        return compare(leftString, rightString);
    }
    public  String compare(String left, String right){
        int min = Math.min(left.length(), right.length());
        for(int i = 0; i < min; i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
// @lc code=end

