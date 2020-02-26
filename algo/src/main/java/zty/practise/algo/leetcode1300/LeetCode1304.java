package zty.practise.algo.leetcode1300;

/**
 * 这道题是求解方案
 * 
 * 本质也是搜索 每一次的选择都和下一次的选择相关联
 * 
 * 其实不需要动态规划，也不需要记录之前的选择 只需要按照一种一定不会重复的规律就可以了 比如递增
 * 
 * 思路2 
 * 定义一个大小为 N 的数组，首先将 0, 1, 2, ..., n - 20,1,2,...,n−2 
 * 这 n-1n−1 个自然数放入数组中，并用 sumsum 记录他们的总和。
 * 对于数组剩下的 11 个空间，我们可以将 -sum−sum 放入其中，
 * 此时数组的这 nn 个数的和一定为 00。
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1304 {

	public int[] sumZero(int n) {
		int[] res = new int[n];
		int i = 0;
		if (n % 2 == 1) {
			res[i++] = 0;
		}
		int num = 1;
		for (; i < n; i++) {
			res[i] = num;
			if (num > 0) {
				num = -num;
			} else {
				num = -(num - 1);
			}
		}

		return res;
	}
}
