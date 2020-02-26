package zty.practise.algo.leetcode500;

/**
 * 这个题主要是要画图，想清楚了解体的点，实现就很简单了
 * 
 * 错误的思路：找左向右第一个向下的拐点，右向左第一个向上的拐点
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode581 {

	/**
	 * 画图，需要的不是排序，遍历性能上也不可取
	 * 
	 * 考虑最值，只需要找到拐点（逆序）中的最大值和最小值
	 * 即最高的下降拐点和最低的上升拐点
	 * 
	 * 需要考虑完全的点是要根据这个点做平行线
	 * 
	 * 容易出错的是 这里不是找第一个拐点和最后一个拐点，而是最高的拐点和最低的拐点
	 * 
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                min = Math.min(min, nums[i]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
