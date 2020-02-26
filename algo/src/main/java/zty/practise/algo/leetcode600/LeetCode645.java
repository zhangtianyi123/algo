package zty.practise.algo.leetcode600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 比较简单
 * 
 * 要么排序
 * 
 * map的思路也比较简单
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode645 {

	public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
	
	public int[] findErrorNums2(int[] nums) {
        Map<Integer, Integer > map = new HashMap();
        int dup = -1, missing = 1;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    dup = i;
            } else
                missing = i;
        }
        return new int[]{dup, missing};
    }


}
