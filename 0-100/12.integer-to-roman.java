/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */
import java.util.Map;
import java.util.HashMap;
class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> integerRomanMap = new HashMap<Integer,String>(){
            {
                put(1,"I");
                put(4,"IV");
                put(5,"V");
                put(9,"IX");
                put(10,"X");
                put(40,"XL");
                put(50,"L");
                put(90,"XC");
                put(100,"C");
                put(400,"CD");
                put(500,"D");
                put(900,"CM");
                put(1000,"M");
            }
        };
        if(num == 0){
            return "";
        }
        int len = Integer.toString(num).length() - 1;
        StringBuffer result = new StringBuffer();
        while(len >= 0){
            int mod = num/(int)Math.pow(10, len);
            System.out.println(mod);
            if(len == 3){
                for (int i = 0; i < mod; i++) {
                    result.append(integerRomanMap.get(1000));
                }
            }else{
                if(integerRomanMap.containsKey(mod*(int)Math.pow(10,len))){
                    result.append(integerRomanMap.get(mod*(int)Math.pow(10,len)));
                }else{
                    if(mod > 5){
                        result.append(integerRomanMap.get(5 * (int)Math.pow(10,len)));
                        for (int i = 0; i < mod - 5; i++) {
                            result.append(integerRomanMap.get((int)Math.pow(10,len)));
                        }
                    }else if(mod < 4){
                        for (int i = 0; i < mod; i++) {
                            result.append(integerRomanMap.get((int)Math.pow(10,len)));
                        }
                    }
                }
            }
            num = num % (int)Math.pow(10, len);
            len--;
        }
        return result.toString();
    }
}

