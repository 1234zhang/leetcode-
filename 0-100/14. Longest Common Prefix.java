class Solution{
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1 ; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() -1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
/**
 * NOTE:
 * 字符串的indexOf函数，查找匹配字符的位置，如果匹配字符在
 * 被匹配字符的前面，则返回零。如果无法匹配则返回-1.
 */
}