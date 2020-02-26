package zty.practise.algo.leetcode1100;

/**
 * 这个结构第一反应就是桶计数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1160 {

	public int countCharacters(String[] words, String chars) {
		int[] bucket = new int[26];
		for(char c : chars.toCharArray()) {
			bucket[c - 'a']++;
		}
		
		int res = 0;
		for(String word : words) {
			int[] t = bucket.clone();
			int n=0;
			for (char c : word.toCharArray()) {
                if(t[c - 'a']-- > 0){
                    n++;
                }
                if(n == word.length())
                	res+=n;
            }
		}
		return res;
		
    }
}
