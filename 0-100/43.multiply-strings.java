/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (31.25%)
 * Likes:    1115
 * Dislikes: 507
 * Total Accepted:    217.4K
 * Total Submissions: 694.3K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        int[] product = new int[n1 + n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                product[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            int temp = (product[i] + carry) % 10;
            carry = (product[i] + carry) / 10;
            product[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < product.length; i++) {
            sb.append(product[i]);
        }
        while(sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

