/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 *
 * https://leetcode.com/problems/gas-station/description/
 *
 * algorithms
 * Medium (34.58%)
 * Likes:    1031
 * Dislikes: 330
 * Total Accepted:    168.8K
 * Total Submissions: 473.2K
 * Testcase Example:  '[1,2,3,4,5]\n[3,4,5,1,2]'
 *
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once in the clockwise direction, otherwise return -1.
 * 
 * Note:
 * 
 * 
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 
 * Output: 3
 * 
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 +
 * 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back
 * to station 3.
 * Therefore, return 3 as the starting index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 
 * Output: -1
 * 
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to
 * the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 =
 * 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you
 * only have 3.
 * Therefore, you can't travel around the circuit once no matter where you
 * start.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int target = 0;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0 || cost.length == 0){
            return -1;
        }
        for(int i = 0; i < gas.length; i++){
            if(gas[i] < cost[i]){
                continue;
            }
            target = i;
            int flag = i;
            boolean isFirst = true;
            int sum = 0;
            while(sum >= 0){
                sum = (sum + gas[target]) - cost[flag];
                if(flag == gas.length - 1){
                    flag = 0;
                }else{
                    flag++;
                }
                
                if(target == gas.length - 1){
                    target = 0;
                }else{
                    target++;
                }
                if(sum >= 0 && target == i){
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

