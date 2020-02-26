package zty.practise.algo.leetcode800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 涉及字符串的匹配，可以现根据长度和哈希值
 * 考虑到大小写 可以根据长度和每一位来判断
 * 
 * 如果不在禁用列表中，由于无法使用桶计数 可以考虑map
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode819 {

	public String mostCommonWord(String paragraph, String[] banned) {
        String[] ps = paragraph.split("(\\s*,\\s*|\\s+)");
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<ps.length; i++) {
        	String p = ps[i];
        	char e = p.charAt(p.length() - 1);
        	if(!((e >= 'a' && e <= 'z') || (e >= 'A' && e <= 'Z'))) {
        		p = p.substring(0, p.length()-1);
        	}
        	int j = 0;
        	p = p.toLowerCase();
    		for(;j<banned.length; j++) {
    			if(p.equals(banned[i]))
    				break;
    		}
    		//不在黑名单
    		if(j == banned.length) {
    			map.put(p, map.getOrDefault(p, 0) + 1);
    		}
        }
        
        int max = -1;
        String maxString = "";
        for(String key : map.keySet()) {
        	if(map.get(key) > max) {
        		max = map.get(key);
        		maxString = key;
        	}
        }
        
        return maxString;
    }
	
	/**
	 * 更好的做法 
	 * 
	 * 不使用分隔和String转小写，直接对字符操作，判断字符是否数字，这样就连带着标点，分隔一起处理了
	 * 
	 * @param paragraph
	 * @param banned
	 * @return
	 */
	public String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

}