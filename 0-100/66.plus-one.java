import java.util.Stack;

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */
class Solution {
    public int[] plusOne(int[] digits) {
        /**Stack<Integer> nums = new Stack<>();
        digits[digits.length - 1] += 1;
        int flag = 0;
        for(int i = digits.length-1; i > 0; i--){
            flag = digits[i]/10;
            nums.push(digits[i]%10);
            digits[i - 1] += flag;
        }
        flag = digits[0]/10;
        nums.push(digits[0]%10);
        if(flag == 1){
            nums.push(flag);
        }
        int[] result = new int[nums.size()];
        int i = 0;
        while(!nums.isEmpty()){
            result[i] = nums.pop();
            i++;
        }
        return result;
        */
        int carry = 1;
    for (int i = digits.length-1; i>= 0; i--) {
        digits[i] += carry;
        if (digits[i] <= 9) // early return 
            return digits;
        digits[i] = 0;
    }
    int[] ret = new int[digits.length+1];
    ret[0] = 1;
    return ret;
    }
    /**
     * 
     * Java 特殊性，在创建数组时。自动初始化数组。
     */
}

