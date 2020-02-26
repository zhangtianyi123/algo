package zty.practise.algo.leetcode800;

public class LeetCode849 {

	/**
	 * 相邻1的长度/2
	 * 
	 * 考虑前导零和后导零
	 * 
	 * @param seats
	 * @return
	 */
	public int maxDistToClosest(int[] seats) {
		int res = 0;
		boolean first = true;
		
		int tmp = 0;
		for(int i=0; i<seats.length; i++) {
			if(seats[i] == 0) {
				tmp++;
			} else if(first) {
				res = Math.max(res, tmp * 2);
				first = false;
				tmp = 0;
			} else {
				res = Math.max(res, tmp + 1);
				tmp = 0;
			}
			
			if(i == seats.length-1 && seats[i] == 0) {
				res = Math.max(res, tmp * 2);
			}
		}
		
		return res / 2;
    }
}
