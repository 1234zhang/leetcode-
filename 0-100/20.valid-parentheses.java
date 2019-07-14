import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        if(s.equals("")) return true;
        HashMap<Character,Character> map = new HashMap<Character,Character>(){
            {
                put('(',')');
                put('{','}');
                put('[',']');
                put(']',' ');
                put(')',' ');
                put('}',' ');
            }
        };
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        stack.push(chars[0]);
        for(int i = 1; i < chars.length; i++){
            if(stack.isEmpty()){
                stack.push(chars[i]);
            }else{
                if(map.get(stack.peek()) == chars[i]){
                stack.pop();
                }else{
                stack.push(chars[i]);
                }
            }
            
        }
        return stack.isEmpty();
    }
}

