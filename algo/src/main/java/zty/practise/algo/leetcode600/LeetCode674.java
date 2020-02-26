package zty.practise.algo.leetcode600;

/**
 * 最长连续递增子序列
 * 
 * 应该说是一道经典的DP题目
 * 
 * 这道题容易的点就在于对于i 可以直接和i-1比较  这个决策的信息是充分的
 * 只需要知道i-1就可以了 并不需要其它的信息
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode674 {

	public int findLengthOfLCIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		
		int max = 1;
        if(n == 0)
            return 0;
		dp[0] = 1;
		for(int i=1; i<n; i++) {
			if(nums[i] > nums[i-1]) {
				dp[i] = dp[i-1] + 1;
			} else {
				dp[i] = 1;
			}
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
    }
}
