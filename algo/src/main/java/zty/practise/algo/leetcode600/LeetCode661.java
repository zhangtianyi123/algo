package zty.practise.algo.leetcode600;

/**
 * 只经历一次状态变化的生命周期
 * 
 * 但是要求所有点位同时变化
 * 
 * 对于每个点为需要两个信息 一个是周边有几个点位，一个是周边点位变化前的数量和
 * 
 * 只要能够同时求得和 周边点位的数量可以根据位置来判断
 * 
 * 举例分析
 * 
 * 是否能先加后减抵消掉呢？
 * 
 * 如果使用新的空间倒是不存在问题
 * 
 * 如果不使用新的空间
 * 
 * 
 * 解法2
 * 可以使用位运算原地修改！！！
 * 因为一个int是32位  如果int的大小有限制那么  有很大一部分空间是可以用于存储方向和其它元素之和信息
 * 
 * @param M
 * @return
 */
public class LeetCode661 {

	/**
	 * 最暴力的额外空间+四重循环
	 * 
	 * @param M
	 * @return
	 */
	public int[][] imageSmoother(int[][] M) {
		int R = M.length, C = M[0].length;
		int[][] ans = new int[R][C];

		for (int r = 0; r < R; ++r)
			for (int c = 0; c < C; ++c) {
				int count = 0;
				for (int nr = r - 1; nr <= r + 1; ++nr)
					for (int nc = c - 1; nc <= c + 1; ++nc) {
						if (0 <= nr && nr < R && 0 <= nc && nc < C) {
							ans[r][c] += M[nr][nc];
							count++;
						}
					}
				ans[r][c] /= count;
			}
		return ans;
	}

}
