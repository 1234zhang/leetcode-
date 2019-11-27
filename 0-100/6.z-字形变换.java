/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (45.64%)
 * Likes:    460
 * Dislikes: 0
 * Total Accepted:    74.9K
 * Total Submissions: 164K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    List<StringBuffer> list = new ArrayList<>();
    public String convert(String s, int numRows) {
        if("".equals(s) || s.length() <= numRows || numRows == 1){
            return s;
        }
        for(int i = 0; i < numRows; i++){
            list.add(new StringBuffer());
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int flag = -1;
        for(char c : chars){
            list.get(i).append(c);
            if(i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuffer result = new StringBuffer();
        for(StringBuffer str : list){
            result.append(str);
        }
        return result.toString();
    }
}
// @lc code=end

