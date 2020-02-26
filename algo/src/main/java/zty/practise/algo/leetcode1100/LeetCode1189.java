package zty.practise.algo.leetcode1100;

/**
 * 关注数量统计而不关注顺序
 * 
 * 找的是木桶的短板
 * 
 * 桶子计数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1189 {

	public int maxNumberOfBalloons(String text) {
		int[] bucket = new int[26];
		
		for(char c : text.toCharArray()) {
			bucket[c - 'a']++;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<bucket.length; i++) {
			if(i == 0 || i == 1 || i == ('n' - 'a')) {
				min = Math.min(min, bucket[i]);
			}
			
			if(i == ('l' - 'a') || i == ('o' - 'a')) {
				min = Math.min(min, bucket[i] / 2);
			}
		}
		
		return min;
    }
}
