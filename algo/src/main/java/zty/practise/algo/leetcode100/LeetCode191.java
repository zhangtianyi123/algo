package zty.practise.algo.leetcode100;

public class LeetCode191 {

	/**
	 * 简单的位运算
	 * 
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		int sum = 0;
		for(int i=0; i<32; i++) {
			int x = 1;
			if((x & n) == 1)
				sum++;
			
			n  = n >>> 1;
		}
		
		return sum;
    }
}
