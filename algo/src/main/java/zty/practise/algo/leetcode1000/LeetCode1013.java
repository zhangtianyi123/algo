package zty.practise.algo.leetcode1000;

public class LeetCode1013 {

	/**
	 * 因为是连续的区间 问题即是两点划分数轴，三区间和相等
	 * 
	 * 考虑动态规划的可能
	 * 
	 * 是否存在（至少一次语义）
	 * 
	 * 按照数学方式转化:
	 * 
	 * D1 = D2 = D3
	 * => S3 = 3D1 , S2 = 2D1
	 * 
	 * @param A
	 * @return
	 */
	public boolean canThreePartsEqualSum(int[] A) {
		int n = A.length;
        int[] sum = new int[n];
        
        for(int i=0; i<n; i++) {
        	sum[i] = A[i];
        	if(i > 0) {
        		sum[i] += sum[i-1];
        	}
        }
        
        boolean first = false;
        if(sum[n-1] % 3 == 0) {
        	for(int i=0; i<n; i++) {
        		if(first && sum[n-1] * 2 == sum[i] * 3) {
        			return true;
        		}
        		if(sum[n-1] == 3 * sum[i]) {
        			first = true;
        		}
        	}
        } else {
        	return false;
        }
        
        return false;
    }
}
