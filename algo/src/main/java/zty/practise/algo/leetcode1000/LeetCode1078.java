package zty.practise.algo.leetcode1000;

import java.util.LinkedList;
import java.util.List;

public class LeetCode1078 {

	/**
	 * 遍历解题即可啊
	 * 
	 * @param text
	 * @param first
	 * @param second
	 * @return
	 */
	public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> res = new LinkedList<>();
        for(int i = 0;i < words.length - 2;i++){
            if(words[i].equals(first) && words[i + 1].equals(second)){
                res.add(words[i + 2]);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
}
