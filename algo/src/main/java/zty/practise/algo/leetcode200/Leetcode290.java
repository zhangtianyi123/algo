package zty.practise.algo.leetcode200;

import java.util.HashMap;
import java.util.Map;

/**
 * 关注
 * 顺序，个数，对应关系
 * 
 * 使用空间
 * 
 * 由于是对应关系map比较合适
 * 
 * 注意是双向
 * 
 * @author zhangtianyi
 *
 */
public class Leetcode290 {

	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Map<String, Character> map2 = new HashMap<>();
		
		String[] ss = str.split(" ");
		if(ss.length != pattern.length())
			return false;
		
		for(int i=0; i<pattern.length(); i++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!ss[i].equals(map.get(pattern.charAt(i)))) {
					return false;
				}
			} else {
				map.put(pattern.charAt(i), ss[i]);
			}
			
			if(map2.containsKey(ss[i])) {
				if(pattern.charAt(i) != map2.get(ss[i])) {
					return false;
				}
			} else {
				map2.put(ss[i], pattern.charAt(i));
			}
		}
		
		return true;
    }
}
