package zty.practise.algo.leetcode900;

import java.util.Arrays;

/**
 * 搜索最大的三个数之和
 * 
 * 搜索的条件是两小边之后大于第三边
 * 
 * 考虑是否能使用动态规划
 * 
 * 先排序，以每个i为结尾的长边，记录其余两边和  也不好弄
 * 
 * 贪心是不行的
 * 
 * 递归回溯？
 * 
 * 暴力搜索：（一定程度上贪心了，只需要找到第一个满足条件的，而且减小了搜索范围）
 * 1 排序
 * 2 从后往前每三个三个的比较
 * 如果排序之后紧挨的三个都不能满足，之前的更不能满足
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode976 {

	public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }

}
