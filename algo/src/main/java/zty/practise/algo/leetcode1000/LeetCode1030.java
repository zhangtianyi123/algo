package zty.practise.algo.leetcode1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的广度优先搜索
 * 
 * 根据题意每一步走1
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1030 {

	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] res = new int[R * C][2];
		int[] x = new int[] { -1, 0, 1, 0 };
		int[] y = new int[] { 0, 1, 0, -1 };
		boolean[][] vis = new boolean[R][C];

		Queue<Node> queue = new LinkedList<>();
		Node head = new Node(r0, c0);
		vis[r0][c0] = true;
		queue.add(head);

		int index = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int r = node.r;
			int c = node.c;

            res[index][0] = r;
			res[index][1] = c;
			index++;

			for (int i = 0; i < 4; i++) {
				int nr = r + x[i];
				int nc = c + y[i];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !vis[nr][nc]) {
					queue.add(new Node(nr, nc));
					vis[nr][nc] = true;
				}
			}

		}
		
		return res;

	}

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
}
