package zty.practise.algo.leetcode900;

public class LeetCode908 {

	/**
	 * 转化为一张柱状图 每个柱子都可以上升下降一定的区间，求最小极差
	 * 
	 * 找最大值和最小值，差值与2k比较
	 * 
	 * 
	 * @param A
	 * @param K
	 * @return
	 */
	public int smallestRangeI(int[] A, int K) {
		int max = -1;
		int min = 10001;
		
		for(int a : A) {
			max = Math.max(max, a);
			min = Math.min(min, a);
		}
		
		return max - min <= 2 * K ? 0 : max - min - 2 * K;
    }
}
