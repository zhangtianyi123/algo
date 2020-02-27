package zty.practise.algo.leetcode200;

import java.util.HashSet;
import java.util.Set;

/**
 * 数字和位置都对
 * 
 * 数字对但是位置不对
 * 
 * 这道搜索题结合了值和位置两个研究对象 
 * 
 * 本来对于第二个研究对象奶牛 想只用桶计数的，但是 +1+1-1-1 对应不只是1 个匹配 而是两个所以不行
 * 考虑使用set 来抵消
 * 
 * set也不对 无法确定谁先出现谁后出现
 * 用两个桶吧
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode299 {
	
	public static void main(String[] args) {
		LeetCode299 s = new LeetCode299();
		s.getHint("1807", "7810");
	}
	
	public String getHint(String secret, String guess) {
		int[] secretBucket = new int[10];
		int[] guessBucket = new int[10];
		
		int A = 0;
		int B = 0;
		for(int i = 0; i<secret.length() && i<guess.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)) {
				A++;
			} else {
				secretBucket[Integer.valueOf(secret.substring(i, i+1))]++;
				guessBucket[Integer.valueOf(guess.substring(i, i+1))]++;
			}
		}
		
		for(int i=0; i<10; i++) {
			B += Math.min(secretBucket[i], guessBucket[i]);
		}
		
		return A + "A" + B + "B";
		
    }
}
