/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (40.88%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    34.9K
 * Total Submissions: 85.3K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] nums = new int[n1 + n2];
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                nums[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            int res = (nums[i] + carry);
            carry = res / 10;
            res = res % 10;
            nums[i] = res;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i]);
        }
        if(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

