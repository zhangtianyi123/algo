package zty.practise.algo.leetcode100;

/**
 * 递归比较左子树和右子树
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode101 {

	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		
		return find(root.left, root.right);
	}

	private boolean find(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		} else if(left != null &&  right != null) {
			boolean res = true;
			res &= left.val == right.val;
			res &= find(left.left, right.right);
			res &= find(left.right, right.left);
			return res;
		} else {
			return false;
		}
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