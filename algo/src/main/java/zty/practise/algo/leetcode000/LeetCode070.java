package zty.practise.algo.leetcode000;

/**
 * 经典题目。。
 * 
 * f(n) = f(n-1) + f(n-2)
 * 
 * 递归没意思 自底向上动态规划来做吧
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode070 {

	public int climbStairs(int n) {
		int[] dp = new int[n+1];
		if(n < 3)
			return n;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
    }
}
