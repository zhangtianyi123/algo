package zty.practise.algo.leetcode700;

/**
 * 能想到的最直接的方式就是桶计数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode747 {

	public int dominantIndex(int[] nums) {
		int[] bucket = new int[1001];

		for (int num : nums) {
			bucket[num]++;
		}

		int max = -1;
		int smax = -1;
		for (int i = 1000; i >= 0; i--) {
			if (max == -1 && bucket[i] > 0) {
				if (bucket[i] > 1)
					return -1;
				max = i;
				continue;
			}

			if (max > -1 && bucket[i] > 0) {
				if (i == 0 || max / i > 1)
					break;
				else
					return -1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == max)
				return i;
		}

		return -1;
	}
	
	/**
	 * 线性扫描 直接搜索法
	 */
	public int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        //找最大
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        
        //找次大
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

}
