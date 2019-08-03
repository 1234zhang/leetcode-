/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */
class Solution {
    public int myAtoi(String str) {
           str = str.trim();
          if(str.length() == 0){
              return 0;
          }
           if(str.charAt(0) != '-' && str.charAt(0) != '+' && !Character.isDigit(str.charAt(0))){
               return 0;
           }
           char[] chars = str.toCharArray();
           boolean pos = false;
           int answer = 0;
           int i = 0;
           if(chars[i] == '-' || chars[i] == '+'){
               pos = chars[i] =='-' ? true : false;
               i++;
           }
           for (; i < chars.length; i++) {
               char var = chars[i];
               if(!pos){
                   if(Character.isDigit(var)){
                       if(answer > Integer.MAX_VALUE/10){
                           return Integer.MAX_VALUE;
                       }
                       answer *= 10;
                       if(answer > Integer.MAX_VALUE - (var - '0')){
                           return Integer.MAX_VALUE;
                       }
                       answer += var - '0';
                   }else{
                   break;
                   }
               }else{
                   if(Character.isDigit(var)){
                       if(-answer < Integer.MIN_VALUE/ 10){
                           return Integer.MIN_VALUE;
                       }
                       answer *= 10;
                       if(-answer < Integer.MIN_VALUE + (var - '0')){
                           return Integer.MIN_VALUE;
                       }
                       answer += var - '0';
                   }else{
                       break;
                   }
               }
           }
           return pos ? -answer : answer;
       }
   }

