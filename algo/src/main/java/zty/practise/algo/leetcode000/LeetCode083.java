package zty.practise.algo.leetcode000;

/**
 * 
 * 和203题如出一辙
 * 
 * 注意哑节点
 * 
 * 注意出现相等的时候 pre要删除下一个节点 但是不要向前走
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode083 {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		
		ListNode dummyNode = new ListNode(head.val - 1);
		dummyNode.next = head;
		ListNode pre = dummyNode;
		
		while(pre.next != null) {
			if(pre.val == pre.next.val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}
		
		return dummyNode.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
