package zty.practise.algo.leetcode1100;

public class LeetCode1175 {

	/**
	 * 排列方案 其实也是数学问题
	 * 
	 * 
	 * 对于n来说 一定是有x个质数索引以及x个质数，所以是求n以内的质数个数
	 * 
	 * 及质数的全排列* 非质数的全排列
	 * 
	 * 那么如何确定质数呢 反向思维 确定非质数
	 * 
	 * @param n
	 * @return
	 */
	public int numPrimeArrangements(int n) {
		boolean[] a = new boolean[n+1];
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=i; j++) {
				if(i * j > n)
					continue;
				a[i*j] = true;
			}
		}
		
		int x = 0;
		for(int i=2; i<=n; i++) {
			if(!a[i])
				x++;
		}
		
		long res = 1;
		for(int i=1; i<=x; i++) {
			res = (res * i) % 1000000007;
		}
		
		for(int i=1; i<=n-x; i++) {
			res = (res * i) % 1000000007;
		}
		
		return (int)res;
	}
}
