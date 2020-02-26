package zty.practise.algo.leetcode1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class LeetCode1200 {

	/**
	 * 思路 1 使用空间统计 2 不使用空间
	 * 
	 * 使用空间： map -- 出现绝对值更小的时候，可以剪枝
	 * 
	 * 不是用空间，又不遍历，那么最小绝对之差小，一定出现于数值相邻的两数
	 * 考虑排序
	 * 
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = arr[n-1] - arr[0];
        List<List<Integer>> res = new ArrayList<>();

        // 遍历第一遍找出min gap
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }

        // 遍历第二遍相邻元素gap与min gap比较即可
        for (int i = 1; i < n; i++) {
            if (min == arr[i] - arr[i-1]) {
            	List<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                res.add(pair);
            }
        }
        return res;
    }

}
