package zty.practise.algo.leetcode100;

/**
 * 链表题目
 * 
 * 判断相交是通过值相等法
 * 
 * 链表有时候总会有一些第一次不容易想到的方法
 * 
 * 比如这道题的双指针拼接法
 * 
 * A + B = B + A
 * 
 * A走完走B  B走完走A 如果相等就是相交点
 * 否则回走到null
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode160 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ha = headA, hb = headB;
		while (ha != hb) {
			ha = ha != null ? ha.next : headB;
			hb = hb != null ? hb.next : headA;
		}
		return ha;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
