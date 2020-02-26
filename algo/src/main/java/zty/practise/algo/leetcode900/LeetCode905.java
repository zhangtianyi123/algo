package zty.practise.algo.leetcode900;

public class LeetCode905 {

	/**
	 * 双指针交换
	 * 
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParity(int[] A) {
		int i = 0;
		int j = A.length-1;
		
		while(i < j) {
			while(i<A.length && A[i] % 2 == 0)
				i++;
			while(j >= 0 && A[j] % 2 != 0)
				j--;
			if(i < j) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			}
			
		}
		
		return A;
	}

}
