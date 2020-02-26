package zty.practise.algo.leetcode800;

/**
 * 树的中序遍历
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode897 {

	//遍历节点
	TreeNode res = null;
	//记录头节点
	TreeNode head = null;

	public TreeNode increasingBST(TreeNode root) {
		findAndJust(root);
		return head;
	}

	//中序遍历，增加新树
	private void findAndJust(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			findAndJust(root.left);
		}

		if (res == null) {
			res = new TreeNode(root.val);
			head = res;
		} else {
			res.right = new TreeNode(root.val);
			res = res.right;
		}

		if (root.right != null) {
			findAndJust(root.right);
		}
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
