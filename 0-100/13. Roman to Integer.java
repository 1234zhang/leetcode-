import java.util.HashMap;

class Solution{
    public int romanToInt(String s){
         HashMap<Character,Integer> map = new HashMap<Character,Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };
        int result = 0;
        char[] chars = s.toCharArray();
        result = map.get(chars[chars.length-1]);
        for(int i = chars.length-2;i >= 0; i--){
            if(map.get(chars[i]) < map.get(chars[i+1])){
                result = result - map.get(chars[i]);
            }else{
                result = result + map.get(chars[i]);
            }
        }
        return result;
    }
}