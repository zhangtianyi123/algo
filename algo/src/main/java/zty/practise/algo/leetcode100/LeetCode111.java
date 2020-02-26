package zty.practise.algo.leetcode100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode111 {

	/**
	 * 无论是深度优先遍历 还是 广度优先遍历都是可以的
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		int dep = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null) {
					return dep;
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				
				size--;
			}
			dep++;
		}
		
		return dep;
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}

