package zty.practise.algo.leetcode000;

/**
 * 
 * 比较简单 主要是要考虑周全各种边界
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode035 {

	public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] >= target) {
        		return i;
        	} 
        }
        return nums.length;
    }
}
