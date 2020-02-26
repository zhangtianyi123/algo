package zty.practise.algo.leetcode900;

/**
 * 不关注值是多少 只要存在左右子树与根节点不同的情况即为false
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode965 {

	public boolean isUnivalTree(TreeNode root) {
		if(root == null)
			return true;
		
		boolean res = true;
		if(root.left != null) {
			res &= root.val == root.left.val;
			res &= isUnivalTree(root.left);
		}
		
		if(root.right != null) {
			res &= root.val == root.right.val;
			res &= isUnivalTree(root.right);
		}
		
		return res;
    }
}
