package zty.practise.algo.leetcode900;

public class LeetCode985 {

	public static void main(String[] args) {
		LeetCode985 s = new LeetCode985();
		s.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1,0}, {-3, 1}, {-4, 0}, {2,3}});
	}
	/**
	 * 关键在于一种动态的思想如果改变的数原来是偶数则减去，如果改变之后的数是偶数则加上
	 * 
	 * 
	 * @param A
	 * @param queries
	 * @return
	 */
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int sum = 0;
		int n = queries.length;
		int[] res = new int[n];
		for(int i : A) {
			if(i % 2 == 0)
				sum += i;
		}
		
		for(int i=0; i<n; i++) {
			if(A[queries[i][1]] % 2 != 0 && queries[i][0] % 2 != 0) {
				sum += A[queries[i][1]] + queries[i][0];
			} else if(A[queries[i][1]] % 2 == 0 && queries[i][0] % 2 == 0) {
				sum += queries[i][0];
			} else if(A[queries[i][1]] % 2 == 0 && queries[i][0] % 2 != 0) {
				sum -= A[queries[i][1]];
			}
			
			A[queries[i][1]] += queries[i][0];
			res[i] = sum;
		}
		
		
		return res;
    }
}
