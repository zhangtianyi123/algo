package zty.practise.algo.leetcode200;

/**
 * 
 * 典型的链表题
 * 
 * 链表的删除很简单
 * 
 * 需要注意1 链表删除需要前驱结点 2 头节点
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode203 {

	public static void main(String[] args) {
		LeetCode203 s = new LeetCode203();
	}

	/**
	 * 使用哨兵
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(val-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        //确保当前结点后还有结点
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
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
