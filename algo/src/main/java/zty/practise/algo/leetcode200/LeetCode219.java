package zty.practise.algo.leetcode200;

import java.util.HashSet;
import java.util.Set;

/**
 * 搜索问题
 * 
 * 如果题目要求是等于k以i, i+k 为滑尺 移动搜索即可
 * 
 * 但是现在的要求是小于等于k
 * 
 * 那么此时第一搜索点不应该是距离（因为距离是动态的，小于等于k是个区间搜索）
 * 
 * 那么转变思路尝试使用相等条件为第一搜索点
 * 
 * 找距离最近的相等数 确定这个最近距离是多少
 * 
 * 可以使用Map（空间换取了大量时间，划算）  否则基本是是平方时间搜索
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode219 {

	/**
	 * 学会使用空间来换取动态搜索的时间
	 * 
	 * 搞清楚关注点和不关注点
	 * 
	 * 关注的是相等数坐标距离极限值
	 * 
	 * 不关注的是是刚刚到达极限值还是还未到达极限值，以及区间内其它元素是什么，及其顺序
	 * 
	 * 手动限定大小的set 类似于实现滑窗的算法
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i < nums.length; i++) {
			if(set.contains(nums[i])) {
				return true;
			}
			
			set.add(nums[i]);
			//滑窗，限定容量
			if(set.size() > k) {
				set.remove(nums[i - k]);
			}
		}	
		
		return false;
    }
}
