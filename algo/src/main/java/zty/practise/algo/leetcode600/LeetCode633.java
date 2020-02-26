package zty.practise.algo.leetcode600;

/**
 * 问题转化为c-一个数的平方，再判断是否为平方数
 * 
 * 二分查找
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode633 {
	
	public static void main(String[] args) {
		LeetCode633 s = new LeetCode633();
		s.judgeSquareSum(1000000);
	}

	public boolean judgeSquareSum(int c) {
		for(int i=0; i*i<=c/2; i++) {
			int ano = c - i*i;
			if(isP(ano)) {
				return true;
			}
			
		}
		
		return false;
    }
	
	private boolean isP(long num) {
		long left = 0;
		long right = num;
		while(left <= right) {
			long mid = left + (right - left) / 2;
			if(mid * mid == num)
				return true;
			else if(mid * mid > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return false;
	}
}
