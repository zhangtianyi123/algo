package zty.practise.algo.leetcode1000;

import java.util.Stack;

/**
 * 
 * 模拟处理？
 * 
 * 寻找规律？
 * 
 * 然后这个匹配方式和括号问题很像
 * 
 * 采用栈吧
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1047 {
	
	public static void main(String[] args) {
		LeetCode1047 s = new LeetCode1047();
		
		System.out.println(s.removeDuplicates("abbaca"));
	}

	public String removeDuplicates(String S) {
        Stack<Character> s = new Stack<>();
        s.push(S.charAt(0));
        
        for(int i=1; i<S.length(); i++) {
        	if(s.size() != 0 && S.charAt(i) == s.peek()) {
        		s.pop();
        	} else {
        		s.push(S.charAt(i));
        	}
        }
        
        StringBuilder res = new StringBuilder();
        while(s.size() != 0) {
        	res.insert(0, s.pop());
        }
        
        return res.toString();
        
    }
}
