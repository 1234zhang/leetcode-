/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (34.49%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 45.6K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    class numCompare implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String str1 = a + b;
            String str2 = b + a;
            return str2.compareTo(str1);
        }
    }
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new numCompare());

        if(str[0].equals("0")){
            return "0";
        }
        String result = "";
        for(String s : str){
            result += s;
        }
        return result;
    }
    
}
// @lc code=end

