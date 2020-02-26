package zty.practise.algo.leetcode700;

/**
 * 首先考虑贪心的可能性
 * 1 100 10000 1
 * 
 * 其次考虑动态规划
 * 
 * 1或2 步的意思是可以跳过任何一个，也可以走到任何一个
 * 
 * dp(n) = min(vn + dp(n-1), vn + dp(n-2))
 * 
 * dpn 是否指示【选择了】第n个的最小方案
 * fn=min(dp(n), dp(n-1))
 * 
 * x x x y
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode746 {

	/**
	 * 关键点自下而上 找到递推关系
	 * 
	 * 考虑初始值 也考虑最后n的结尾情况
	 * 
	 * 一定注意dp数组是【选择第i个】，而非直接的表示i以内数组的最小值
	 * 
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];
		dp[0] = cost[0];
		dp[1] = cost[1];
		
		for(int i = 2; i<n; i++) {
			dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
		}
		
		return Math.min(dp[n-1], dp[n-2]);
    }
}
