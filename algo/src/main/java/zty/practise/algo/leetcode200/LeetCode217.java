package zty.practise.algo.leetcode200;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 使用set 是划算的
 * 
 * 简单的排序也可以
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode217 {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		
		for(int num : nums) {
			if(set.contains(num))
				return true;
			set.add(num);
		}
		
		return false;
    }
}
