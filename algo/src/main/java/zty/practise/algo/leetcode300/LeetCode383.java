package zty.practise.algo.leetcode300;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串本质上是一串有顺序的字符
 * 
 * 但是题目忽略顺序，在意的是有没有和有多少
 * 
 * 这个时候使用空间是比较划算的做法
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode383 {

	public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<ransomNote.length(); i++) {
        	map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        
        for(int i=0; i<magazine.length(); i++) { 
        	if(map.containsKey(magazine.charAt(i))) {
        		map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
        	}
        }
        
        for(int i=0; i<ransomNote.length(); i++) {
        	if(map.containsKey(magazine.charAt(i)) && map.get(magazine.charAt(i)) > 0) {
        		return false;
        	}
        }
        
        return true;
    }
}
