package zty.practise.algo.leetcode1100;

/**
 * 环形图
 * 
 * 有权，计算两个端点的权值和 比较大小
 * 
 * 这题确实简单 唯一需要多考虑下的就是
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1184 {

	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int dis = 0;
		int sum = 0;
		boolean flag = false;
		for(int i=0; i < distance.length; i++) {
			sum += distance[i];
			if(i == start || i == destination) {
				flag = !flag;
			} 
			if(flag) {
				dis += distance[i];
			}
		}
		
		return Math.min(dis, sum - dis);
    }
}
