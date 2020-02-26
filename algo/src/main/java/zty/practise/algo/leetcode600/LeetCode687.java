package zty.practise.algo.leetcode600;

/**
 * 对于每个节点，sun(left相同的，right相同的)
 * 
 * 关键方法是要用递归的思路去想（其实和动态规划的思路本质上是一样的）
 * 再去比较每个节点的max
 * 
 * 对于一个节点而言 只需要关注其左节点和右节点的关联
 * 
 * 中间想漏了的一点就是对于左节点和右节点递归返回的时候只能选取其中一条 否则不能构成V
 * 
 *       x
 *     x    x
 *   x  x  x  x
 *   
 *   如上如果全选则错误 对于第二层，只能选择左右中的一条
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode687 {

	int max = 0;
	
	public int longestUnivaluePath(TreeNode root) {
        find(root);
        return max;
    }
	
	/**
	 * 当前节点为根的最大连续数
	 * 
	 * @param root
	 * @return
	 */
	public int find(TreeNode root) {
		if(root  == null)
			return 0;
		
		int arrowLeft = 0, arrowRight = 0;
		int left = find(root.left);
		int right = find(root.right);
		if(root.left != null && root.val == root.left.val) {
			arrowLeft += left + 1;
		} 
		
		if(root.right != null && root.val == root.right.val) {
			arrowRight += right + 1;
		}
		
		max = Math.max(max, arrowLeft + arrowRight);
		//不能直接返回res,注意左右子节点只能取一条边，否则构不成V字型
		return Math.max(arrowLeft, arrowRight);
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

