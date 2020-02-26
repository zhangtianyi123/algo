package zty.practise.algo.leetcode1200;

public class LeetCode1266 {
	
	/**
	 * 因为必须按照顺序访问 
	 * 所以题目简化了很多，分解成独立的子问题
	 * 
	 * 尽可能走斜线（效率更好），斜线有两种走法，比较
	 * 
	 * 想象一个图形，一个点为基点，四十五度画两条直线，划分出四个区域，
	 * 先走斜线，再走直线，比较x,y差值
	 * 
	 * 空间思维能力
	 * 
	 * @param points
	 * @return
	 */
	public int minTimeToVisitAllPoints(int[][] points) {
		int sum = 0;
		if(points.length > 1) {
			for(int i=0; i<points.length-1; i++) {
				int x2 = (points[i][0] - points[i+1][0]) * (points[i][0] - points[i+1][0]);
				int y2 = (points[i][1] - points[i+1][1]) * (points[i][1] - points[i+1][1]);
				if(x2 > y2) {
					sum += Math.sqrt(2 * y2);
					sum += Math.sqrt(x2) - Math.sqrt(y2);
				} else if(x2 < y2) {
					sum += Math.sqrt(2 * x2);
					sum += Math.sqrt(y2) - Math.sqrt(x2);
				} else {
					sum += Math.sqrt(x2 + y2);
					continue;
				}
			}
		}
		
		return sum;
    }
}
