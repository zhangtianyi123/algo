package zty.practise.algo.leetcode000;

public class LeetCode069 {

	/**
	 * 二分查找对数时间
	 * 
	 * 
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		int low = 0;
		int high = x;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(mid * mid > x) {
				high = mid - 1;
			} else if(mid * mid < x) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		
		return high;
		
    }
	
	/**
	 * 应对特殊整形，可以使用长整形
	 * 
	 * @param x
	 * @return
	 */
    public int mySqrt2(int x) {
		long low = 0;
		long high = x;
		while(low <= high) {
			long mid = low + (high - low) / 2;
			if(mid * mid > x) {
				high = mid - 1;
			} else if(mid * mid < x) {
				low = mid + 1;
			} else {
				return (int)mid;
			}
		}
		
		return (int)high;
		
    }
}
