package zty.practise.algo.leetcode600;

public class LeetCode665 {

	/**
	 * 
	 * 遍历通过相邻点的比较 
	 * 
	 * 但是要注意第一次出现逆序对的时候 调整两个节点中的任何一个均可【i，i+1】
	 * 但是如果i-1 比两者中小的还小（即i+1）  并且  i+2 比两者中大的还大（即i） 那么不论调整哪一个 另一个也会让情况不满足
	 * 排除边界情况
	 * 
	 * 通过画图，想到了两点前后的两个点也会影响，但是要想清楚如何影响通过画图是最好的
	 * 
	 * @param nums
	 * @return
	 */
	public boolean checkPossibility(int[] nums) {
		int n = 0;
		
		for(int i=0; i<nums.length-1; i++) {
			if(nums[i] > nums[i+1]) {
				n++;
				if(n > 1)
					return false;
				
				if(i > 0 && nums[i-1] > nums[i+1] && i < nums.length - 2 && nums[i] > nums[i+2]) {
					return false;
				}
			}
		}
		
		return true;
    }
}
