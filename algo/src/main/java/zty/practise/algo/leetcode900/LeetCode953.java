package zty.practise.algo.leetcode900;

import java.util.HashMap;
import java.util.Map;

/**
 * 先一轮判定长度（可能更短的符合，比如第一个字母已经满足字典序，未必后者更短就一定更小）
 * 
 * 之后挨个比较
 * 两个字母可以同时比较，分别用indexOf相对来说就浪费些性能了
 * 
 * 但是如果用Mao来（缓存）每个字符的角标位置就更快了
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode953 {
	
	public static void main(String[] args) {
		LeetCode953 s = new LeetCode953();
		s.isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
	}

	public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
}
