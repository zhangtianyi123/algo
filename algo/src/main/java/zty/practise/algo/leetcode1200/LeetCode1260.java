package zty.practise.algo.leetcode1200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * 模拟矩阵操作，交换元素即可
 * 
 * 注意点：当移动次数等于二维数组的大小及其整数倍时, 数组的状态不发生改变 这个遗漏了 应该想到的
 * 
 * 取模之后就不用一次一次模拟了 可以一步到位
 * 
 * 解法2：
 * 
 * 更奇葩的举例+画图 发现这个变化其实非常有意思，相当于是每一行向后一位，每一行的最后 一位移动到下一行的第一位，最后一行的最后一位
 * 
 * [ - - - - - | - - -]
 * 
 * 可以借助双端队列数据结构
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1260 {

	public static void main(String[] args) {
		LeetCode1260 s = new LeetCode1260();
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		s.shiftGrid(grid, 9);
	}
	
	/**
	 * @param grid
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int n = grid.length;
		int m = grid[0].length;

		k = k % (n * m);

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Deque<Integer> mDeque = new ArrayDeque<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				mDeque.add(grid[i][j]);
			}
		}
		
		for(int i=0; i<k; i++) {
			int t = mDeque.pollLast();
			mDeque.addFirst(t);
		}
		
		for(int i=0; i<n; i++) {
			List<Integer> line = new ArrayList<Integer>();
			for(int j=0; j<m; j++) {
				line.add(mDeque.pollFirst());
			}
			res.add(line);
		}

		return res;

	}

}
