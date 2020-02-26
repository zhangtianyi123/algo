package zty.practise.algo.leetcode1000;

import java.util.Arrays;

/**
 * 什么时候要挥霍k呢 全部正数的时候 如果挥霍来还剩一个，则加在最小的那个上
 * 
 * 举例 负数=5 k=10 k = 5 - (10-5) % 2;
 * 
 * 即找出最大的k个负数（-1 0 n）
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1005 {

	public static void main(String[] args) {
		LeetCode1005 s = new LeetCode1005();
		s.largestSumAfterKNegations(new int[] {5, 6,9,-3,3}, 2);
	}
	
	public int largestSumAfterKNegations(int[] A, int K) {
		Arrays.sort(A);

		int sum = 0;
		int first = -1;
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			if (a < 0) {
				if (K > 0) {
					sum -= a;
					K--;
				} else {
					sum += a;
				}
			} else {
				if(first < 0) {
					first = i;
				}
				sum += a;
			}
		}
		
		/**
		 * 全是正数
		 * 全是负数
		 * 有负数有正数，就要比较最小正数和最大负数的绝对值，看颠倒谁
		 * 
		 */
		if(K % 2 != 0) {
			if(first < 0) {
				//加上两倍最大负数
				sum += 2 * A[A.length - 1];
			} else if(first == 0) {
				//减去两倍最小正数
				sum -= 2 * A[0];
			} else {
				sum += A[first] + A[first-1] >=0 ? 2 * A[first-1] : -2 * A[first];
			}
		}

		return sum;
	}
}
