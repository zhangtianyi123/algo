package zty.practise.algo.leetcode500;


/**
 * 递归描述
 * 
 * 右中左序遍历逐项累加
 * 
 *       2
 *    0      3
 *  1   1
 *  
 *  对于0来说就是加上自身，与右边所有节点之和（1，2，3）
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode538 {

	//遍历中上一个节点运算后的值
	int pre = 0;
	public TreeNode convertBST(TreeNode root) {
        TreeNode pre = root;
		find(root);
		return pre;
    }
	
	private int find(TreeNode node) {
		if(node == null)
			return 0;
		
		find(node.right);
		pre += node.val;
		node.val = pre;
		
		find(node.left);
		
		return node.val;
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
