/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (33.73%)
 * Likes:    955
 * Dislikes: 250
 * Total Accepted:    148.5K
 * Total Submissions: 437K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
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
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * \Output: "2314"
 * 
 * 
 */
import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int dev = 1;
        for (int i = 1; i < n; i++) {
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
            dev = dev/(n - 1);
            n--;
        }
        sb.append(nums.get(0));
        return sb.toString();
    }
}

