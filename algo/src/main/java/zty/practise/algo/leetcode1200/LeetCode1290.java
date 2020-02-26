package zty.practise.algo.leetcode1200;

/**
 * 迭代乘2 即可
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1290 {

	public int getDecimalValue(ListNode head) {
		int res = 0;
		while(head != null) {
			int val = head.val;
			res = res * 2 + val;
            head = head.next;
		}
		
		return res;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
