package zty.practise.algo.leetcode500;


/**
 * 对于一个节点
 * 出发向左搜索最深的距离 + 出发向右搜索最深的距离  即是以那个点为路径拐点（或者起点）的答案
 * 
 * 每个点都比较 max一次
 * 
 * 但是往上递归的时候只能提供max(sumLeft, sumRight);
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode543 {
	
	int max = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		find(root);
		return max;
    }
	
	/**
	 * 返回左右最长深度值
	 * 
	 * 一个是要统计每一个节点
	 * 但是对于递归的过程
	 * 每个节点都必须选择，递归+1
	 * 而且只能选择左或者右一边 而不是两边长度之和
	 * 
	 * @param node
	 * @return
	 */
	public int find(TreeNode node) {
		if(node == null)
			return 0;
		
		int left = find(node.left);
		int right = find(node.right);
		
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
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
