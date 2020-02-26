package zty.practise.algo.leetcode500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 因为数值范围过大 不适用桶计数
 * 
 * 排序？
 * 
 * 再用动态移动的两个指针寻找
 * 
 * 这道题又是一道广义的限制条件的搜索题
 * 
 * 如果有a < b <c 如果ab满足条件 ac以及a与c以后一定不满足
 * 
 * 考虑0和非0 情况
 * 
 * 可以借助set
 * 
 * 思路
 * 计算两个数之间的关系，正常的暴力破解的思维是需要循环套循环 O(n*n)的时间复杂度。
但是可以利用两数之间的关系， 把其中一个转换为另一个，这样只需要一层for循环即可。
本题中的两数关系为： x-y=k 那么有 x=y+k 和 y=x-k。
只要把数组中的所有数据都存储到哈希表中，遍历时，检查 x+k 和 x-k 是否在数组中即可。
此外用另一个哈希表来记录diff对。只需记录diff对中的较大值或较小值即可。我记录的是较小值。
 * 
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode532 {

	/**
	 * 因为关注的是有没有，不重复
	 * 1 1 1 3  （k=2） 只有1 3  所以可以考虑 使用set
	 * 考虑k=0的【特殊情况】 1 1 1 3 （k=0） 1必须set里面要有
	 * 1 出现第二次的时候才会判断为满足条件
	 * 
	 * 最后再对结果去重
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Set<Integer> condition = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums) {
        	if(condition.contains(num+k)) {
        		res.add(num);
        	}
        	if(condition.contains(num-k)) {
        		res.add(num-k);
        	}
            condition.add(num);
        }
        
        return res.size();
    }
	
	/**
	 * 使用二分查找
	 * 如果不使用set去重就需要排序，并跳过相同的数值，每个相同的数字只判断统计一次
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) 
                continue;
            int target = Arrays.binarySearch(nums, i+1, nums.length, nums[i] + k);
            if (target >= 0 && i != target) 
                res++;
        }
        return res;
    }

	/**
	 * 可以使用双指针，自行的去排序再搜索
	 * 
	 * 这样可以根据滑窗，大小关系剪掉更多的枝，性能最好，但是也最有难度最费思量
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs3(int[] nums, int k) {
		if(k < 0) 
			return 0;
        Arrays.sort(nums);
        int small = 0;
        int count = 0;
        int prev = Integer.MAX_VALUE;
        
        for (int big = 1; big < nums.length; ) {
        	//small->big的差值过大，small向后滑动
            if(nums[big] - nums[small] > k || prev == nums[small]) {
                if (small+1 != big) {
                	small++;
                }
                big++;
            }else if (nums[big] - nums[small] == k) {
            	//small->big符合条件则small与big之后的数字没有比较的必要，差值一定大于k，所以滑动small和big
                prev = nums[small];
                small++;
                big++;
                count++;
            } else if(nums[big] - nums[small] < k) {
            	big++;
            }
            //small->big的差值过小，则向后滑动big
        }
        return count;

	}
}
