package zty.practise.algo.leetcode1200;

public class LeetCode1217 {

	/**
	 * 注意题目的理解，数组的值存放的是筹码的位置
	 * 
	 * 求最小值
	 * 
	 * 因为左右移动偶数步骤实不小号代价的，又可以考虑不限制操作次数，只用考虑最后移动一步
	 * 
	 * 即可以转化为所有在奇数位置的都无代价的移动到1，所有偶数位置的都无代价移动到2
	 * 
	 * @param chips
	 * @return
	 */
	public int minCostToMoveChips(int[] chips) {
		int a = 0;
		int b = 0;
		
		for(int i : chips) {
			if(i % 2 == 0) {
				a++;
			} else {
				b++;
			}
		}
		
		return Math.min(a, b);
		
	}
}
