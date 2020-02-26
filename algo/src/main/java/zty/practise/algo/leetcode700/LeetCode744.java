package zty.practise.algo.leetcode700;


/**
 * a-z 形成了一个圆环
 * 
 * 莫名想到了一致性哈希算法
 * 
 * 使用字母桶吧
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode744 {

	public char nextGreatestLetter(char[] letters, char target) {
		int[] bucket = new int[26];
		for(char c : letters) {
			bucket[c - 'a']++;
		}
		
		int i = target - 'a';
		while(true) {
			i++;
			if(i == 26)
				i=0;
			if(bucket[i] > 0)
				return (char)(i+'a');
		}
		
    }
}
