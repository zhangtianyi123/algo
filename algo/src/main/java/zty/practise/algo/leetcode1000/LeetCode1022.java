package zty.practise.algo.leetcode1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1022 {

	/**
	 * 深度优先搜索找出所有的二进制
	 * 
	 * 二进制转为十进制
	 * 
	 * 求和
	 * 
	 * @param root
	 * @return
	 */
	public int sumRootToLeaf(TreeNode root) {
		String sb = "";
		List<String> list = new ArrayList<>();

		dfs(root, sb, list);

		int res = 0;
		for (String b : list) {
			if (!"".equals(b)) {
				int i = Integer.valueOf(b, 2) % 1000000007;
				res = (res + i) % 1000000007;
			}
		}

		return res;
	}

	private void dfs(TreeNode root, String sb, List<String> list) {
		if (root == null) {
			return;
		}

		sb += root.val;

		if (root.left == null && root.right == null) {
			list.add(sb);
			return;
		}

		dfs(root.left, sb, list);
		dfs(root.right, sb, list);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
