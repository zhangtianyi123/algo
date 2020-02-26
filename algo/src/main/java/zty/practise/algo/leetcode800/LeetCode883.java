package zty.practise.algo.leetcode800;

public class LeetCode883 {

	/**
	 * 空间几何找到数学规律
	 * 
	 * 分成三个面分别统计 每个i最大的，每个j最大的 + i * j
	 * 
	 * 
	 * @param grid
	 * @return
	 */
	public int projectionArea(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] a = new int[n];
		int[] b = new int[m];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0) {
					a[i] = Math.max(a[i], grid[i][j]);
					b[j] = Math.max(b[j], grid[i][j]);
					sum++;
				}
			}
		}
		
		for(int i : a) {
			sum += i;
		}
		
		for(int i : b) {
			sum += i;
		}
		
		return sum;
	}
}
