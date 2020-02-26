package zty.practise.algo.leetcode1300;

/**
 * 题目虽然简单 但是还真的反映了一点编解码的思想
 * 
 * 先求长度避免list的动态扩容浪费和拷贝
 * 双指针
 * 
 * 双百效率
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1313 {

	public int[] decompressRLElist(int[] nums) {
		int n = 0;
		
		for(int i=0; i<nums.length; i+=2) {
			n += nums[i];
		}
		
		int[] res = new int[n];
		int p=0;
		for(int i=0; i<nums.length; i+=2) {
			for(int j=0; j<nums[i]; j++) {
				res[p++] = nums[i+1];
			}
		}
		
		return res;
    }
}
