package zty.practise.algo.leetcode400;

import java.util.TreeSet;

/**
 * 
 * 第一反应就是堆（优先队列）
 * 
 * 维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
 * 
 * 最后如果Set中元素小于3就返回Set最大值，否则返回最小值。
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode414 {

	public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0)
        	throw new RuntimeException("error");

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) 
            	set.remove(set.first());
        }
        
        return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
    }

}
