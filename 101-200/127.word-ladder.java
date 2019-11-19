/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (24.94%)
 * Likes:    2035
 * Dislikes: 942
 * Total Accepted:    323.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int n = beginWord.length();
        Map<String, List<String>> allDirect = new HashMap<>();
        wordList.forEach(word -> {
            for(int i = 0; i < n; i++){
                String str = word.substring(0, i) + "*" + word.substring(i + 1);
                if(!allDirect.containsKey(str)){
                    allDirect.put(str, new ArrayList<String>());
                }
                allDirect.get(str).add(word);
            }
        });

        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();

        begin.add(beginWord);
        end.add(endWord);
        HashSet<String> visited = new HashSet<String>();
        
        int len = 1;

        while(!begin.isEmpty() && !end.isEmpty()){
            if(begin.size() > end.size()){
                HashSet<String> cur = begin;
                begin = end;
                end = cur;
            }

            HashSet<String> neighbor = new HashSet<>();
            for(String tmp : begin){
                for(int i = 0; i < n; i++){
                    String cur = tmp.substring(0, i) + "*" + tmp.substring(i + 1);
                    if(!allDirect.containsKey(cur)){
                        continue;
                    }
                    for(String str : allDirect.get(cur)){
                        if(end.contains(str)){
                            return len + 1;
                        }
                        if(!visited.contains(str)){
                            visited.add(str);
                            neighbor.add(str);
                        }
                    }
                }
            }
            begin = neighbor;
            len++;
        }
        return 0;
    }
}
// @lc code=end

