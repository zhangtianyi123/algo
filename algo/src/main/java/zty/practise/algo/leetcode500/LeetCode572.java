package zty.practise.algo.leetcode500;

public class LeetCode572 {
	
	/**
	 * 查子树
	 * 任何一个点都有可能
	 * 
	 * 其实本质上和找子串思想一样
	 * 
	 * 考虑能否不采用long*logm的方式，能否优化
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null)
			return false;
		
		return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	
	public boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t == null)
			return true;
		else if(s != null && t != null) {
			return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
		}
		else
			return false;
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
