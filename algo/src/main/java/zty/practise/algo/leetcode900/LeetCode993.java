package zty.practise.algo.leetcode900;

/**
 * 树搜索 两个关键值
 * 深度和父节点
 * 
 * 信息的紧凑存储： val = val*100+depth
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode993 {

	int px = 0;
	int py = 0;
	int dx = 0;
	int dy = 0;
	public boolean isCousins(TreeNode root, int x, int y) {
		if(root == null)
			return false;
		
		findx(root, x, 0);
		findy(root, y, 0);
		
		return px != py && dx == dy;
	}
	
	private void findx(TreeNode node, int target, int depth) {
		if(node == null)
			return;
		
		depth++;
		if(node.left != null && node.left.val == target) {
			 px = node.val;
			 dx= depth;
			 return;
		}
		
		if(node.right != null && node.right.val == target) {
			 px = node.val;
			 dx= depth;
			 return;
		}
		
		findx(node.left, target, depth);
		findx(node.right, target, depth);
	}
	
	private void findy(TreeNode node, int target, int depth) {
		if(node == null)
			return;
		
		depth++;
		if(node.left != null && node.left.val == target) {
			 py = node.val;
			 dy= depth;
			 return;
		}
		
		if(node.right != null && node.right.val == target) {
			 py = node.val;
			 dy= depth;
			 return;
		}
		
		findy(node.left, target, depth);
		findy(node.right, target, depth);
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
