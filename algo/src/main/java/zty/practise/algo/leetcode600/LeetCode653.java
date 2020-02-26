package zty.practise.algo.leetcode600;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 平衡二叉树
 * 
 * 要利用平衡二叉树的特性
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode653 {

	/**
	 * 
	 * 逆向思维  两个数不好处理  问题转变为  查找一个数  k - root.val
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
	
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
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