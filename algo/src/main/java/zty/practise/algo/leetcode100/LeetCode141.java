package zty.practise.algo.leetcode100;

/**
 * 链表中的环
 * 
 * 是经典的链表题目 
 * 快慢指针解法也是经典的解法
 * 
 * 但是只要知道思路 就会者不难了
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode141 {

	public boolean hasCycle(ListNode head) {
        if(head == null)
        	return false;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	
        	if(slow == fast)
        		return true;
        }
        
        return false;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}