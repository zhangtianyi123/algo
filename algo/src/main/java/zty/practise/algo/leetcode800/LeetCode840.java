package zty.practise.algo.leetcode800;

import java.util.HashSet;
import java.util.Set;

/**
 * 本质上是一道搜索题
 * 
 * 先确定规律 应该说总和只能够是15 且中心只能够是5
 * 
 * 剪枝 应该说不用确定所有线
 * 
 * 思路2 ： 遍历统计所有长度为3的横竖斜线段和是否15  复用
 * 
 * 思路3 ： 进一步寻找规律 简化搜索
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode840 {

	public int numMagicSquaresInside(int[][] grid) {
		int res = 0;
		int n = grid.length;
		int m = grid[0].length;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (grid[i][j] == 5) {
					if (grid[i - 1][j] + grid[i + 1][j] == 10 && grid[i][j - 1] + grid[i][j + 1] == 10
							&& grid[i - 1][j - 1] + grid[i + 1][j + 1] == 10
							&& grid[i + 1][j - 1] + grid[i - 1][j + 1] == 10) {
						if(grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] == 15 && grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] == 15 && grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1] == 15 && grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1] == 15) {
							Set<Integer> set = new HashSet<>();
							for(int x=-1;x<=1;x++)
			                {
			                    for(int y=-1;y<=1;y++)
			                        if(grid[i+x][j+y]<10 && grid[i+x][j+y]>0)
			                            set.add(grid[i+x][j+y]);
			                }
							if(set.size() == 9)
								res++;
							
						}
					}
				}
			}
		}
		
		return res;
	}
}


