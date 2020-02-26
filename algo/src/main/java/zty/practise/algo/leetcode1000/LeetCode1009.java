package zty.practise.algo.leetcode1000;

/**
 * 按位处理
 * 
 * 
 * 001000100
 * 
 * 因为不知道哪些0是前导零
 * 
 * 不妨逢1再处理
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1009 {

	public int bitwiseComplement(int N) {
		int res = 0;
		int count = 0;
		while(N != 0) {
			int p = N & 1;
			if(p == 1) {
				res += Math.pow(2, count);
			} 
			count++;
			
			N >>>= 1;
		}
		
		return res;
    }
}
