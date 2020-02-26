package zty.practise.algo.leetcode700;

/**
 * 如果使用空间
 * 
 * 使用左到右和右到左的sum数组
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode724 {

	public int pivotIndex(int[] nums) {
		int n = nums.length;
        if(n==0)
        return -1;
		int[] leftSum = new int[n];
		int[] rightSum = new int[n];
		
		for(int i=0; i<n; i++) {
			leftSum[i] = nums[i];
			if(i > 0) {
				leftSum[i] += leftSum[i-1];
			}
		}
		
		for(int i=n-1; i>=0; i--) {
			rightSum[i] = nums[i];
			if(i < n-1) {
				rightSum[i] += rightSum[i+1];
			}
		}
		
		if(n==1 || rightSum[1]==0)
			return 0;
		for(int i=1; i<n-1; i++) {
			if(leftSum[i-1] == rightSum[i+1]) {
				return i;
			}
		}
		if(n == 1 || leftSum[n-2]==0)
			return n-1;
		
		return -1;
    }
	
	/**
	 * 简化一边实时统计
	 * 
	 * 利用了总和的数学运算，这样还顺便把边界条件处理了
	 * @param nums
	 * @return
	 */
	public int pivotIndex2(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums)
        	sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) 
            	return i;
            leftsum += nums[i];
        }
        return -1;
    }

}
