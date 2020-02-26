package zty.practise.algo.leetcode700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 层次遍历
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode700 {

	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null)
			return root;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(queue.size() > 0) {
			TreeNode node = queue.poll();
			if(val == node.val)
				return node;
			
			if(node.left != null)
				queue.offer(node.left);
			if(node.right != null)
				queue.offer(node.right);
		}
		
		return null;
		
    }
	
	public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
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
