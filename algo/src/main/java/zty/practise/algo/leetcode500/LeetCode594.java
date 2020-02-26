package zty.practise.algo.leetcode500;

/**
 * 不要求连续啊
 * 
 * 折线图
 * 
 * 有限制的话用桶计数会比较好 没有的话 map也是可以做的
 * 
 * 否则可以考虑动态规划
 * 
 * 可以枚举数组中的每一个元素，对于当前枚举的元素 x，它可以和 x + 1 组成和谐子序列。我们再遍历一遍整个数组，找出等于 x 或 x + 1 的元素个数
 * O(N2)
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode594 {

	public int findLHS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i])
                    count++;
                else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag)
                res = Math.max(count, res);
        }
        return res;
    }

}
