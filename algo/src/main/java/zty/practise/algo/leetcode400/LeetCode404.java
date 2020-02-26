package zty.practise.algo.leetcode400;

public class LeetCode404 {

	/**
	 * 需要一个额外的参数来表示是不是来源于左侧
	 * 
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {
        return help(root, false);
    }
	
	public int help(TreeNode root, boolean isLeft) {
        if(root == null)
        	return 0;
        
        if(isLeft && root.left == null && root.right == null)
        	return root.val;
        
        return help(root.left, true) + help(root.right, false);
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