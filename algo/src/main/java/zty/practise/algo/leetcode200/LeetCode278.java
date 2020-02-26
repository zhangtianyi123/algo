package zty.practise.algo.leetcode200;

/**
 * 变种的二分查找
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode278 {

	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(isBadVersion(mid)) {
				if(mid == 0 || !isBadVersion(mid-1)) {
					return mid;
				} else {
					right = mid - 1;
				}
			} else {
				left = mid + 1;
			}
		}
		return -1;
    }
	
	public int firstBadVersion2(int n) {
	    int left = 1;
	    int right = n;
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        if (isBadVersion(mid)) {
	            right = mid;
	        } else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}

	
	/**
	 * 占位
	 * 
	 * @param version
	 * @return
	 */
	boolean isBadVersion(int version) {
		return true;
	}
}
