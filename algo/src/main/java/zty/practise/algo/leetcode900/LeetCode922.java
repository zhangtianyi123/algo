package zty.practise.algo.leetcode900;

public class LeetCode922 {
	/**
	 * 其实排序算法的思想真的可以借鉴到所有的列表或者数组处理
	 * 
	 * 使用两个指针
	 * 
	 * 只要都不满足正确位置的时候，交换即可
	 * 
	 * 交换操作！
	 * 
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParityII(int[] A) {
		if(A.length < 2)
			return A;
		
		int i = 0;
		int j = 1;
		
		while(i < A.length && j < A.length)  {
			int t = A[i];
			A[i] = A[j];
			A[j] = t;
			
			if(A[i] % 2 == 0) {
				i += 2;
			}
			
			if(A[j] % 2 != 0) {
				j += 2;
			}
			
		}
		
		return A;
		
	}
}
