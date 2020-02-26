package zty.practise.algo.leetcode400;

/**
 * 
 * 二叉树的排列书没有规律的
 * 
 * 相当于字符串的任意位置的子串
 * 
 * 完全的便利定位起点再确定长度的复杂度是不可取的
 * 
 * 那么就只能利用动态的思想，利用已知信息
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode437 {

	public int pathSum(TreeNode root, int sum) {
		if(root == null)
			return 0;
		
		int res = 0;
		res += find(root, sum);
		
		res += pathSum(root.left, sum);
		res += pathSum(root.right, sum);
		
		return res;
    }
	
	public int find(TreeNode root, int sum) {
		if(root == null)
			return 0;
		
		sum -= root.val;
		
		return find(root.left, sum) + find(root.right, sum) + (sum == 0 ? 1 : 0);
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
