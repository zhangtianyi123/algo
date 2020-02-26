package zty.practise.algo.leetcode600;

public class LeetCode643 {

	/**
	 * 连续的 长度固定的 那么动态性很小了，搜索范围骤减
	 * 
	 * 平均数最大在长度固定的前提下，即sum最大
	 * 
	 * 关键点就在于不重复计算，充分利用信息
	 * 即加上最左的，减去最右的
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
        for(int i=0; i<nums.length; i++) {
        	if(i < k) {
        		sum += nums[i];
                if(i == k-1)
                  max = Math.max(max, sum);
        	} else {
        		sum += nums[i] - nums[i-k];
        		max = Math.max(max, sum);
        	}
        }
        
        return max * 1.0 / k;
    }
}
