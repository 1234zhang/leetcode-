/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (47.41%)
 * Likes:    158
 * Dislikes: 0
 * Total Accepted:    20.2K
 * Total Submissions: 42.2K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        List<Integer> nums= new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        int dev = 1;
        for(int i = 1; i < n; i++){
            dev *= i;
        }
        while(nums.size() > 1){
            int flag = k / dev;
            if(k % dev == 0){
                sb.append(nums.get(flag - 1));
                nums.remove(flag - 1);
                k = k - dev * (flag - 1);
            }else{
                sb.append(nums.get(flag));
                nums.remove(flag);
                k = k - dev * flag;
            }
            dev = dev / (n - 1);
            n--;
        }
        return sb.append(nums.get(0)).toString();
    }
}
// @lc code=end

