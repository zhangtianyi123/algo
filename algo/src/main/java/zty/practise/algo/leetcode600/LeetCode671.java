package zty.practise.algo.leetcode600;

import java.util.LinkedList;

public class LeetCode671 {

	/**
	 * 已知节点非空，且每个节点的子节点都大于等于本身，所以无需遍历所有节点，
	 * 
	 * 只需找到每个子树中的第一个不等于根节点的值。
	 * 
	 * 目标值可能在左子树和右子树中，递归查找出第一个不等于根节点的值即可。
	 * 
	 * @param root
	 * @return
	 */
	public int findSecondMinimumValue(TreeNode root) {
        int result = findSecondMinDefaultMin(root, root.val);
        return result==root.val ? -1 : result;
    }
    
    private int findSecondMinDefaultMin(TreeNode node, int min){
        if(node==null){
            return min;
        }
        
        if(node.val==min){
            int left = findSecondMinDefaultMin(node.left, min);
            int right = findSecondMinDefaultMin(node.right, min);
            if(left != min && right != min){
                return Math.min(left,right);
            }else if (left != min){
                return left;
            }else if (right != min){
                return right;
            }else{
                return min;
            }
        }else{
        	//不等于最小就是次小
            return node.val;
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
