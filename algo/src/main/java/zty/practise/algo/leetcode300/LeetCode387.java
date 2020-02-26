package zty.practise.algo.leetcode300;

/**
 * 一个字符重复与否必须要全部搜索完之后才能确定
 * 
 * 由于只包含小写字母 所以桶计数有了用武之地
 * 
 * 桶与hashmap的性质上有相似之处
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode387 {

	public int firstUniqChar(String s) {
		int[] bucket = new int[26];
		for(char c : s.toCharArray()) {
			bucket[c - 'a']++;
		}
		
		for(int i=0; i<s.length(); i++) {
			if(bucket[s.charAt(i) - 'a'] == 1)
				return i;
		}
		
		return -1;
    }
}
