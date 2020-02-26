package zty.practise.algo.leetcode900;

/**
 * 
 * 利用二叉搜索树的顺序性
 * 
 * 通过二叉树的图形结构可知
 * 
 * 正向：L和R的上面的节点 加上L的右子树和R的左子树
 * 
 * 逆向：全部节点值减去L的左子树和R的右子树
 * 
 * 思路：
 * 应该采用中序遍历（中序遍历其实就是从小到大的顺序）
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode938 {

	int sum = 0;
	
	public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
        	return 0;
        
        rangeSumBST(root.left, L, R);
        if(root.val >= L && root.val <= R) {
        	sum += root.val;
        }
        rangeSumBST(root.right, L, R);
        
        return sum;
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