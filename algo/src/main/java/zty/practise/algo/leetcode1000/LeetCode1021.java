package zty.practise.algo.leetcode1000;

import java.util.Stack;

/**
 * 
 * 这个没啥好说的  
 * 
 * 括号是栈最经典的应用了
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1021 {
	
	public static void main(String[] args) {
		LeetCode1021 s = new LeetCode1021();
		s.removeOuterParentheses("(()())(())");
	}

	//(()())(())
	public String removeOuterParentheses(String S) {
		Stack stack = new Stack();
		StringBuilder tmp = new StringBuilder();
		StringBuilder res = new StringBuilder();
		
		char[] cs = S.toCharArray();
		for(int i=0; i<cs.length; i++) {
			if(cs[i] == '(') {
				stack.push('(');
				tmp.append('(');
			} else {
				stack.pop();
				tmp.append(')');
				if(stack.size() == 0) {
					tmp.deleteCharAt(0);
					tmp.deleteCharAt(tmp.length() - 1);
					res.append(tmp);
					tmp = new StringBuilder();
				}
			}
		}
		
		return res.toString();
    }
}
