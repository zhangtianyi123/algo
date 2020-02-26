package zty.practise.algo.leetcode600;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 搞清楚是贪心问题还是排列规划问题
 * 
 * 排列规划问题特质： 很多问题的本质都是一样的
 * 
 * a b c d 四个有序的数
 * 
 * a * c 与 b * d 这种【交叉的形式】大小是不一定的
 * 
 * 所以不能以贪心的方式，需要考虑各种排列组合
 * 
 * 这道题是贪心问题，特殊点在于负负得正
 * 
 * 正结果 1 正正正 2 正负负
 * 
 * 负结果 3 正正负 4 负负负
 * 
 * 用两个list来存储正数和负数，插入的时候顺便排序
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode628 {

	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		/**
		 * 避免了条件判断，直接比较，反正只有四种可能情况
		 * 
		 */
		int a = nums[0] * nums[1] * nums[2];
		a = Math.max(a, nums[n-1] * nums[n-2] * nums[n-3]);
		a = Math.max(a, nums[0] * nums[n-1] * nums[n-2]);
		a = Math.max(a, nums[0] * nums[1] * nums[n-1]);
				
		return a;		
	}
}
