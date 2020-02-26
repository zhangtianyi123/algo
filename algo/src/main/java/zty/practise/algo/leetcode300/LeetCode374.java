package zty.practise.algo.leetcode300;

/**
 * 相当于是二分查找的简单实现
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode374 {

	public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	if(guess(mid)  == 0) {
        		return mid;
        	} else if(guess(mid) == 1) {
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        return -1;
    }

	/**
	 * 无实际作用假设占位的方法
	 * 
	 * @param num
	 * @return
	 */
	public int guess(int num) {
		return 0;
	}
}
