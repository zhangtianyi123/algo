package zty.practise.algo.leetcode200;

import java.util.ArrayList;
import java.util.List;

public class LeetCode234 {

	/**
	 * 考虑能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
	 * 
	 * 逆序 - 栈
	 * 
	 * 找到中点 - 快慢指针
	 * 
	 * 问题在于不能反向查询遍历
	 * 
	 * 链表反转
	 * 
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;
		
		ListNode slow = head;
		ListNode fast = head;
		
		//走完后slow在中点或者中点前一位
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode second = slow.next;
		slow.next = null;
		
		//反转
		ListNode pre = null;
		while(second != null) {
			ListNode nextTmp = second.next;
			second.next = pre;
			pre = second;
			second = nextTmp;
		}

		while(pre != null) {
			if(pre.val != head.val) {
				return false;
			}
			pre = pre.next;
			head = head.next;
		}
		
		return true;
    }

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
