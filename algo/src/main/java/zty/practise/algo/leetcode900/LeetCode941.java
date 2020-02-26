package zty.practise.algo.leetcode900;


/**
 * 
 * 画图可知需要是一个三角形
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode941 {

	public boolean validMountainArray(int[] A) {
		if(A.length < 3)
			return false;
		
		int i = 1;
		boolean isv = false;
		boolean a = false;
		boolean b = false;
		while (i < A.length) {
			if(!isv) {
				if(A[i] < A[i-1]) {
					isv = true;
					continue;
				} else if(A[i] == A[i-1]) {
					return false;
				}
				a = true;
			} else {
				if(A[i] >= A[i-1]) {
					return false;
				}
				b = true;
			}
			
			i++;
		}
		
		if(!a || !b) {
			return false;
		}
		
		return true;
		
    }
}
