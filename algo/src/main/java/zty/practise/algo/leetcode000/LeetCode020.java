package zty.practise.algo.leetcode000;

import java.util.Stack;

/**
 * 括号就是想到栈
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode020 {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		if(s == null)
			return true;
		
		for(char c : s.toCharArray()) {
			if(stack.empty() || !isMatch(stack.peek(), c)) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}
		
		return stack.isEmpty();
    }
	
	private boolean isMatch(char a, char b) {
		if(a == '(') {
			return b == ')';
		} else if(a == '[') {
			return b == ']';
		} else if(a == '{') {
			return b == '}';
		}
		
		return false;
	}
}
