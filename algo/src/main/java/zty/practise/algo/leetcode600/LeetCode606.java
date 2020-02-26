package zty.practise.algo.leetcode600;

/**
 * 递归的考虑就是root(root.left)(root.right)
 * 
 * 注意空的判断 左空右不空 需要放入左边的空括号
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode606 {

	public String tree2str(TreeNode t) {
		if(t == null)
			return "";
		
		String res = String.valueOf(t.val);
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		
		if(left == "" && right != "") {
			left = "()";
		}
		
		if(left == "()")
			res = res + left;
        else if(left != "")
            res = res + "(" + left + ")";
		
		if(right != "")
			res = res + "(" + right + ")";
		
		return res;
	}
	
	public String tree2str2(TreeNode t) {
        if(t==null)
            return "";
        if(t.left==null && t.right==null)
            return t.val+"";
        if(t.right==null)
            return t.val+"("+tree2str(t.left)+")";
        return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";   
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
