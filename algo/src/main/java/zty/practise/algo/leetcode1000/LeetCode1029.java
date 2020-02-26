package zty.practise.algo.leetcode1000;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * 制定一钟分配方案
 * 
 * 一半一半
 * 
 * 求最值
 * 
 * 每个人都可以飞到A或B 但是有限定条件
 * 
 * 回溯/ 动态规划
 * 
 * 但是问题在于前面的选择会干扰后面的选择
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1029 {

	int min = Integer.MAX_VALUE;

	/**
	 * 公司首先将这 2N 个人全都安排飞往 B 市，再选出 N个人改变它们的行程，让他们飞往 A市。
	 * 
	 * 如果选择改变一个人的行程，那么公司将会额外付出 price_A - price_B 的费用，这个费用可正可负
	 */
	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o1[1] - (o2[0] - o2[1]);
			}
		});

		int total = 0;
		int n = costs.length / 2;

		// 前n个人飞往A市，后n个人飞往B市
		for (int i = 0; i < n; ++i)
			total += costs[i][0] + costs[i + n][1];
		return total;
	}

	/**
	 * 回溯写对了 但是超出时间限制
	 * 
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost2(int[][] costs) {
		int n = costs.length / 2;

		help(costs, 0, 0, n, 0);

		return min;
	}

	private void help(int[][] costs, int i, int choose, int n, int sum) {
		if (i == n * 2) {
			min = Math.min(min, sum);
			return;
		}

		// A已经选满了
		if (choose == n) {
			// 选B
			help(costs, i + 1, choose, n, sum + costs[i][1]);
		}

		// B已经选满了
		else if (i - choose == n) {
			// 选A
			help(costs, i + 1, choose + 1, n, sum + costs[i][0]);
		}

		else {
			help(costs, i + 1, choose, n, sum + costs[i][1]);
			help(costs, i + 1, choose + 1, n, sum + costs[i][0]);
		}
	}
}
