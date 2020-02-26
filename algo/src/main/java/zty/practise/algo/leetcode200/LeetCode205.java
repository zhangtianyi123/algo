package zty.practise.algo.leetcode200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 这里本质上是一种一一映射关系
 * 考虑使用map
 * 
 * 而且本来就需要全盘比较 不使用空间是不现实的
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();

		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				if(map.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}
			} else {
				map.put(s.charAt(i), t.charAt(i));
                //反向的，s第一次出现的字符，t不能已经出现过
                if(set.contains(t.charAt(i)))
                    return false;
                set.add(t.charAt(i));
			}
		}
        
		return true;
    }
}
