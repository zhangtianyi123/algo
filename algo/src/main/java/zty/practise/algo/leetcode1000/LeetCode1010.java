package zty.practise.algo.leetcode1000;

public class LeetCode1010 {

	/**
	 * 遍历
	 * 
	 * 是否能不采用遍历
	 * 
	 * 60倍数的不确定性 --- 对60取模
	 * 
	 * 因为上下限确定，可以采用计数排序的思想了
	 * 
	 * 用到了一点数学的思想
	 * 
	 * a + b = n * 60
	 * => a % 60 + b % 60 = 60
	 * 
	 * 方法论: 计数法与取模是一对
	 * 
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public int numPairsDivisibleBy60(int[] time) {
		
		int[] a = new int[60];
		for(int t : time) {
			a[t%60]++;
		}
		
		int sum = 0;
		for(int i=1; i<30; i++) {
			sum += a[i] * a[60-i];
		}
		
		int n = a[30];
		sum += (n * (n-1)) / 2;
		
		n = a[0];
		sum += (n * (n-1)) / 2;
		
		return sum;
    }
}
