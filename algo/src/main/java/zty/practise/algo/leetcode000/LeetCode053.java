package zty.practise.algo.leetcode000;

/**
 * 第一想法  sum(n -> m) = sum(m) - sum(n);
 * 
 * 问题转化为两数差值最大，但是问题在于必须是后者大，前者小
 * 
 * 那就两个指针向着中间靠拢（否定）
 * 
 * 动态规划，f(n) 与 f(n-1)
 * 
 * 可以使用贪心！
 * 
 * dpi 以 i结尾
 * 
 * dp[0]、dp[1]、……、dp[n - 1] 都看一遍，取最大值
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode053 {

	/**
	 * 使用原數組作爲动态规划数组
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
	    int n = nums.length;
	    int max = nums[0];
	    for(int i = 1; i < n; ++i) {
	      if (nums[i - 1] > 0) 
	    	  nums[i] += nums[i - 1];
	      max = Math.max(nums[i], max);
	    }
	    return max;
	  }
	
	/**
	 * 一定要想清楚含义
	 * 
	 * dp[i] 代表以nums[i]为结尾的最大连续子串
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
	    int n = nums.length;
	    int max = nums[0];
	    int[] dp = new int[n];
	    dp[0] = nums[0];
	    for(int i = 1; i < n; ++i) {
	      if (dp[i - 1] < 0) {
	    	  //重新開始
	    	  dp[i] = nums[i];
	      } else {
	    	  //连上
	    	  dp[i] = dp[i-1] + nums[i];
	      }
	      max = Math.max(dp[i], max);
	    }
	    return max;
	  }

}
