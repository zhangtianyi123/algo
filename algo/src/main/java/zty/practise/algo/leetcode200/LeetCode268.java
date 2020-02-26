package zty.practise.algo.leetcode200;

public class LeetCode268 {

	/**
	 * 使用空间就很好做，那么在不使用空间的基础上
	 * 
	 * 数学方式是可以的
	 * 
	 * 位运算可能也具备规律
	 *
	 * 
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		for(int num : nums) {
			sum -= num;
		}
		
		return sum;
    }
}
