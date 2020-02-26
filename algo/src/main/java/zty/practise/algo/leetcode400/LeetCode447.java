package zty.practise.algo.leetcode400;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 以i为中心，考虑与它距离相等的元素的个数即为要求
 * 
 * 假设x有n个举例它相同的点 则对应有 n(n-1)个回旋镖
 * 
 * 距离可以使用勾股定理
 * 
 * 可以不采用遍历吗 可以使用数据结构辅助比如ashMap
 * 
 * 优化：不使用n(n-1)的统计规律 而使用动态规律 每增加一个相同的点  增加 2 * (n-1)
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode447 {

	private int d2(int x1, int x2, int y1, int y2) {
		int d1 = x1 - x2;
		int d2 = y1 - y2;
		return d1 * d1 + d2 * d2;
	}

	public int numberOfBoomerangs(int[][] points) {
		int sum = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					int d = d2(points[i][0], points[j][0], points[i][1], points[j][1]);
					map.put(d, map.getOrDefault(d, 0) + 1);
				}
			}
			for (Integer value : map.values()) {
				if (value > 1) {
					sum += value * (value - 1);
				}
			}

		}

		return sum;
	}
}
