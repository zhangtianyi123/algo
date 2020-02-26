package zty.practise.algo.leetcode000;

/**
 * 和083题类似
 * 
 * 但是相比于链表的指针操作 数组的角标操作就简单多了
 * 
 * 数组原地赋值，快慢指针咯（尤其适合数组结果会压缩变短的场景）
 * 
 * 快慢指针是需要掌握的一场方式
 * 
 * 或者从O(N)的角度出发 只能够边走边放
 * 
 * 不过也可坑看出 链表和数组处理的方式完全不一样
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode026 {

	public int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}

}
