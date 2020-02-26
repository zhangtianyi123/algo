package zty.practise.algo.leetcode600;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 众数可能有一个也可能有多个
 * 
 * 第一步先需要找到众数
 * 众数考虑桶计数
 * 如果痛的范围可嫩过大  可以考虑使用map
 * 
 * 假设找到了多个众数问题转化为确认这些众数出现最短的那个
 * 
 * 问题是两步能不能合二为一 
 * 阻碍在于一个桶难以一次存储两个信息
 * 
 * 但是可以在一个时间维度里面完成
 * 需要使用三个桶空间
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode697 {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> left = new HashMap<>();
		Map<Integer, Integer> right = new HashMap<>();
		Map<Integer, Integer> bucket = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			bucket.put(nums[i], bucket.getOrDefault(nums[i], 0) + 1);
			if(left.get(nums[i]) == null)
				left.put(nums[i], i);
			right.put(nums[i], i);
		}
		
		int ans = nums.length;
		int degree = Collections.max(bucket.values());
		for(int num : bucket.keySet()) {
			if(bucket.get(num) == degree) {
				ans = Math.min(ans, right.get(num) - left.get(num) + 1);
			}
		}
		return ans;
    }
}
