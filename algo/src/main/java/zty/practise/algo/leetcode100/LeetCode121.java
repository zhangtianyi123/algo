package zty.practise.algo.leetcode100;

/**
 * 简单的搜索题
 * 
 * 搜索区间：一个
 * 搜索对象：两个
 * 搜索限制条件：i < j && prices[i] < prices[j]
 * 
 * 
 * 降序返回0
 * 
 * 不能排序 则数据与数据之间没有联系
 * 
 * 使用空间
 * 比如i 确定为卖出的那一天 此时的最大利润为dp[i]
 * 那么
 * 
 * eg:
 * 6 5 1 4
 * 
 * 
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode121 {
	
	/**
	 * 一次成功
	 * 
	 * 1 dpi i这一天一定要卖出股票
	 * 2 max(0, 每一天卖出股票中利润最大的)
	 * 3 对于固定的一天i 卖出的最大利润，因为有前一天卖出的最大利润，
	 * 那么最大利润就是i-1天不卖，第i天卖（买入的那一天仍然不变）
	 * 或者第i-1天买入，第i天卖出  比较这两种方案
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] dp = new int[n];
		if(n <2)
			return 0;
		if(n == 2)
			return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
		
		int max = 0;
		dp[0] = 0;
		dp[1] = prices[1] - prices[0];
		max = Math.max(dp[1], max);
		for(int i=2; i<n; i++) {
			dp[i] = prices[i] - prices[i-1] + (dp[i-1] > 0 ? dp[i-1] : 0);
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
}
