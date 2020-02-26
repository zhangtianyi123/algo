package zty.practise.algo.leetcode900;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933 {

	/**
	 * 因为是一次次的调用ping 所以粗腰数据结构来记录
	 * 记录每一次调用的时间戳
	 * 
	 * 数据结构：队列
	 * （清除缓存）
	 * 
	 * @author zhangtianyi
	 *
	 */
	static class RecentCounter {

		Queue<Integer> q;
		
		public RecentCounter() {
			q = new LinkedList();
		}

		/**
		 * 既把自己作为一次调用加入 又要返回此时之前3000毫秒的数据
		 * 需要注意的是3000ms 之前的数据可以删除了（即相对更早的）
		 * 因为之后的数据一定不会统计到它们
		 * 
		 * @param t
		 * @return
		 */
		public int ping(int t) {
			q.add(t);
	        while (q.peek() < t - 3000)
	            q.poll();
	        return q.size();

		}
	}
}
