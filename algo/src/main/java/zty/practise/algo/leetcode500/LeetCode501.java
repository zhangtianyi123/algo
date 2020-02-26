package zty.practise.algo.leetcode500;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果仅仅是二叉树，是一定需要额外空间的
 * 
 * 但是BST 二叉搜索树是否可能利用其大小规律不使用额外空间呢
 * 
 * 中序遍历 从小到大 左中右
 * 在遍历的基础上问题其实转化为在一个有序链表中查找众数
 * 
 * 需要记录三个关键：当前众数，前一个值，目前众数的个数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode501 {

	List<Integer> res = new ArrayList<>();
    TreeNode pre;
    int max = 0;
    int cur = 1;
    public int[] findMode(TreeNode root) {
        if(root==null) {
            return new int[] {};
        }
        find(root);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    private void find(TreeNode root) {
        if(root==null) {
            return ;
        }
        find(root.left);
        if(pre!=null) {
            if(pre.val==root.val) {
                cur++;
            }
            else {
                cur=1;
            }
        }
        if(cur==max) {
        	res.add(root.val);
        }else if(cur>max) {
        	res.clear();
        	res.add(root.val);
            max=cur;
        }
        pre=root;
        find(root.right);
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
