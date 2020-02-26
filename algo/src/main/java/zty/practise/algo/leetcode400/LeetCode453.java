package zty.practise.algo.leetcode400;

/**
 * 想象成一个柱状图
 * 
 * n-1个+1  就可以转化为   1个减1
 * 
 * 所以结果就是sum(every - min)
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode453 {

	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;

		for(int num : nums) {
			min = Math.min(min, num);
		}
		
		int sum = 0;
		for(int num : nums) {
			sum += num - min;
		}
		
		return sum;
    }
}
