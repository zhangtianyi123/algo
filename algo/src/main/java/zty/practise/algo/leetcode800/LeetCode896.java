package zty.practise.algo.leetcode800;

public class LeetCode896 {

	/**
	 * 关键是看单调的方向是否变过
	 * 
	 * @param A
	 * @return
	 */
	public boolean isMonotonic(int[] A) {
		if(A.length == 1) {
			return true;
		}
		
		int flag = 0;
		for(int i=1; i<A.length; i++) {
			if(A[i] > A[i-1]) {
				if(flag < 0) {
					return false;
				}
				flag = 1;
			} else if(A[i] < A[i-1]) {
				if(flag > 0) {
					return false;
				}
				flag = -1;
			}
		}
		
		return true;
    }
}
