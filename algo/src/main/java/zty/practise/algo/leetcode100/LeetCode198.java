package zty.practise.algo.leetcode100;

/**
 * 搜索题
 * 
 * 目标：选择的数据之和最大
 * 限制：不选择相邻的
 * 
 * 因为限制存在关联关系，所以贪心不可行，考虑使用动态规划
 * 
 * 假设选择第i个数，前i的最大值
 * 
 * x x-1 x-2 x-3 x-4
 * 
 * 选择x 的最大值就等于 x + max(f(x-2) + f(x-3)) 不可能是x-4
 * 反证可知，如果选择x-4的话，那么x-2就可以选择，这种方式囊括在f(x-2)里面，所以不成立
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode198 {

	public int rob(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		if(nums.length == 2)
			return Math.max(nums[0],nums[1]);
		if(nums.length == 3)
			return Math.max(nums[1], nums[0] + nums[2]);
		
		int[] f = new int[nums.length];
		f[0] = nums[0];
		f[1] = Math.max(nums[0],nums[1]);
		f[2] = Math.max(nums[1], nums[0] + nums[2]);
		
		for(int i=3; i<nums.length; i++) {
			f[i] = nums[i] + Math.max(f[i-2], f[i-3]);
		}
		
		return Math.max(f[nums.length-1], f[nums.length-2]);
		
    }
}
