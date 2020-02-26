package zty.practise.algo.leetcode1100;

public class LeetCode1137 {

	/**
	 * 斐波那契数想到的就是递归
	 * 
	 * 或者使用循环
	 * 
	 * 可以使用空间内存进行缓存剪枝
	 * 
	 * @param n
	 * @return
	 */
	
	
	public int tribonacci(int n) {
		int[] a = new int[38];
		return tribonacci(n, a);
    }
	
	public int tribonacci(int n, int[] a) {
		if(a[n] != 0)
			return a[n];
		if(n < 2) 
			return n;
		
		if(n < 4)
			return n-1;
		
		//先算小的，更快
		a[n] = tribonacci(n-3, a) + tribonacci(n-2, a) + tribonacci(n-1, a);
		
		return a[n];
    }
	
}
