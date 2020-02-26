package zty.practise.algo.leetcode100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode155 {

	/**
	 * 入栈很好处理，但是如果出栈的正好是最小元素，那么怎么确定新的最小元素呢？
	 * 
	 * 所以只是存储一个是不行的，但是如果存储所有浪费太大，那么是否可以只存当前最小值和次小值
	 * 类似链表
	 * 
	 * 其实对于每一个数字为止，其最小值是确定的，那么可以用一个结构体/类  或者两个栈
	 * class Node{}
	 * 
	 * 两个栈或者一个栈+map都可以
	 * 
	 * @author zhangtianyi
	 *
	 */
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(-10);
		ms.push(14);
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());
		ms.push(-20);
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		ms.push(10);
		ms.push(-7);
		System.out.println(ms.getMin());
		ms.push(-7);
		ms.pop();
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
	}
	
	static class MinStack {

		Stack<Integer> stack;
		Map<Integer, Integer> map;
		
	    /** initialize your data structure here. */
	    public MinStack() {
			stack = new Stack<>();
			map = new HashMap<>();
			map.put(0, Integer.MAX_VALUE);
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        map.put(stack.size(), Math.min(x, map.get(stack.size() - 1)));
	    }
	    
	    public void pop() {
	        stack.pop();
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return map.get(stack.size());
	    }
	}
}
