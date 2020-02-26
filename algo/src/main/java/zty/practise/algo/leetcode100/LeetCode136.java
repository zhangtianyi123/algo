package zty.practise.algo.leetcode100;

public class LeetCode136 {

	/**
	 * 利用了位运算，异或的特性
	 * 
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }
}
