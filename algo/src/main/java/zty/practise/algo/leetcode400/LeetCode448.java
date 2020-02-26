package zty.practise.algo.leetcode400;

import java.util.ArrayList;
import java.util.List;

/**
 * 关键在于如何不使用额外空间
 * 
 * 有些一次 有些两次
 * 大小都在n之内
 * 
 * 如果使用时间 排序也很方便
 * 
 * 能不能更快呢？
 * 
 * 可以直接利用角标存储
 * 
 * 交换
 * 
 * 或者采用一种取巧的方式
 * 角标本身的信息和数字信息保存在同一个位置里面，通过负数打标记的方式
 * 
 * 【本质是一种信息的紧凑存储的思想，和信息隐藏有点像，同样的空间存储更大量的信息】
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode448 {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			int t = Math.abs(nums[i]);
			if(nums[t-1] > 0) {
				nums[t-1] = -nums[t-1];
			}
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				res.add(i+1);
			}
		}
		
		return res;
    }
}
