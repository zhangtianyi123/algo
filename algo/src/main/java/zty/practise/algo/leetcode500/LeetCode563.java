package zty.practise.algo.leetcode500;

/**
 * 递归搜索
 * 
 * 这个题目的递归意义的表明应该还是简单清晰的
 * 
 * 统计左右子树之和能够递归的利用（坡度是之差  是不行的）
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode563 {

    int res = 0;
	public int findTilt(TreeNode root) {
		find(root);
		return res;
    }
	
	private int find(TreeNode node) {
		if(node == null)
			return 0;
		
		int leftSum = find(node.left);
		int rightSum = find(node.right);
		
		res += Math.abs(leftSum - rightSum);
		
		return leftSum + rightSum + node.val;
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
