package zty.practise.algo.leetcode1300;

/**
 * 本质上是通过有序来对搜索剪枝
 * 
 * if (i, j) 是负数 那么  >=i && >=j  的点一定是负数
 * 
 * 二分查找。
 * 
 * 倒序遍历
 * 从右上角（或者左下角）开始
 * 
 * 举例
 * 4  3  2  1
 * 3  2  1  -1
 * 1  1  -1  -2
 * 1  -1  -2  -3
 * 
 * 从右上角开始向下找到第一个负数，这一列就结束了
 * 再找倒数第二列，不用从1，开始，直接坐标横移，从
 * 上一列第一个负数开始，比如上图-1
 * 横移为1  为什么从这里开始呢  因为-1是第一个负数意味着
 * 当列上一个不是负数即1 那么2更大就更不会是负数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1351 {

	/**
	 * 画图，举例
	 * 不要把事情搞得太过于复杂
	 * 
	 * 成功的利用了行列俩的顺序特性
	 * 
	 * @param grid
	 * @return
	 */
	public int countNegatives(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
		int i = 0;
		int j = m-1;
		int res = 0;
		while(i<n && j >= 0) {
			//找到第一个负数即停止，这里利用了第一个规律
			while(i<n && grid[i][j] >= 0) {
				i++;
			}
			res += n - i;
			//直接横移，这里利用了第二个规律
			j--;
		}
		
		return res;
	}
}
