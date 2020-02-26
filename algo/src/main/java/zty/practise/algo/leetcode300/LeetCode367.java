package zty.practise.algo.leetcode300;


/**
 *  思路1 : 从1 开始递增平方判断
 * 
 * 不过也可以使用二分插好
 * 设置左边界为 2，右边界为 num/2
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode367 {

	public boolean isPerfectSquare(int num) {
	    if (num < 2) {
	      return true;
	    }

	    long left = 2, right = num / 2, x, guessSquared;
	    while (left <= right) {
	      x = left + (right - left) / 2;
	      guessSquared = x * x;
	      if (guessSquared == num) {
	        return true;
	      }
	      if (guessSquared > num) {
	        right = x - 1;
	      } else {
	        left = x + 1;
	      }
	    }
	    return false;
	  }

}
