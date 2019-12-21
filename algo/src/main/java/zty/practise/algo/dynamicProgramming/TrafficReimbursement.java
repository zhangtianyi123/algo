package zty.practise.algo.dynamicProgramming;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 无论是地铁票，滴滴票，还是出租车票，票面金额固定不可分割
 * 
 * 在进行交通报销的时候，如何在满足报销额度，比如300的基础上
 * 
 * 使得总金额最小呢？
 * 
 * @author zhangtianyi
 *
 */
public class TrafficReimbursement {

	int minSum = Integer.MAX_VALUE;
	
	/**
	 * 贪心算法容易反证得无法获取到全局最优解
	 * 
	 * @author zhangtianyi
	 * @param amountLimit 报销额度
	 * @param bills 每张票据的金额
	 * @return 满足报销额度的最小金额
	 */
	public int greedy(int amountLimit, List<Integer> bills) {
		Collections.sort(bills);
		int res = 0;
		
		for(Integer bill : bills) {
			res += bill;
			if(res >= amountLimit) {
				break;
			}
		}
		
		return res;
	}
	
    /**
     * 暴力递归回溯，可以取得全局最优解
     * 
     * 实例变量minSum表示满足报销额度的最小金额
     * 
     * @author zhangtianyi
     * @param i 第i张票据
     * @param sum 选择到第i张票据时候的总价
     * @param amountLimit 报销额度
     * @param bills 每张票据的金额
     */
	public void Recursion(int i, int sum, int amountLimit, List<Integer> bills) {
		if(i == (bills.size() - 1) || sum >= amountLimit) {
			if(sum < minSum) {
				minSum = sum;
			}
			return;
		}
		
		Recursion(i+1, sum, amountLimit, bills);
		Recursion(i+1, sum+bills.get(i), amountLimit, bills);
	}
	
	/**
	 * 剪枝的递归回溯，可以取得全局最优解
	 * 
	 * @author zhangtianyi
     * @param i 第i张票据
     * @param sum 选择到第i张票据时候的总价
     * @param amountLimit 报销额度
     * @param bills 每张票据的金额
	 * @param mem 记录递归树中已经出现过的节点
	 */
	public void RecursionCut(int i, int sum, int amountLimit, List<Integer> bills, Set<String> mem) {
		if(i == (bills.size() - 1) || sum >= amountLimit) {
			if(sum < minSum) {
				minSum = sum;
			}
			return;
		}
		if(mem.contains(i + "-" + sum)) {
			return;
		}
		mem.add(i + "-" + sum);
		
		Recursion(i+1, sum, amountLimit, bills);
		Recursion(i+1, sum+bills.get(i), amountLimit, bills);
	}
	
	/**
	 * 动态规划，使用二维的可达数组正向分析，可以获取到全局最优解
	 * 
	 * @author zhangtianyi
	 * @param amountLimit
	 * @param bills
	 * @return 满足报销额度的最小金额,-1表示满足额度的组合方式至少超过限度两倍
	 */
	public int dynamicProgrammingOne(int amountLimit, List<Integer> bills) {
		//二维可达数组（决策第i张票据 ，票据总价）
		boolean[][] states = new boolean[bills.size()][2*amountLimit+1];
		
		states[0][0] = true;
		if(bills.get(0) <= 2*amountLimit) {
			states[0][bills.get(0)] = true;
		}
		
		for(int i=1; i<bills.size(); i++) {
			for(int sumAmount=0; sumAmount<=2*amountLimit; sumAmount++) {
				if(states[i-1][sumAmount]) {
					//第i张票据不选择
					states[i][sumAmount] = true;
					if(sumAmount + bills.get(i) <= 2*amountLimit) {
						//第i张票据选择
						states[i][sumAmount+ bills.get(i)] = true;
					}
				}
			}
		}
		
		int res = -1;
		for(res = amountLimit; res <= amountLimit*2; res++) {
			if(states[bills.size()-1][res])
				break;
		}
		
		return res;
	}
	
	/**
	 * 动态规划，使用一维的可达数组正向分析，忽略掉动态规划层数，可以获取到全局最优解
	 * 
	 * @author zhangtianyi
	 * @param amountLimit
	 * @param bills
	 * @return 满足报销额度的最小金额,-1表示满足额度的组合方式至少超过限度两倍
	 */
	public int dynamicProgrammingTwo(int amountLimit, List<Integer> bills) {
		boolean[] states = new boolean[2*amountLimit+1];
		
		states[0] = true;
		if(bills.get(0) <= 2*amountLimit) {
			states[2*amountLimit] = true;
		}
		
		for(int i=1; i<bills.size(); i++) {
			for(int sumAmount=amountLimit*2; sumAmount>=0; sumAmount--) {
				if(states[sumAmount]) {
					states[sumAmount + bills.get(i)] = true;
				}
			}
		}
		
		int res = -1;
		for(res = amountLimit; res <= amountLimit*2; res++) {
			if(states[res])
				break;
		}
		
		return res;
	}
	
}
