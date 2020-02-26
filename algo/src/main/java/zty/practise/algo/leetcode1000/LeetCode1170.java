package zty.practise.algo.leetcode1000;

import java.util.Arrays;

/**
 * 首先queries 的每个i之间是没有关联的
 * 
 * 分析当i确定的时候
 * 
 * 能计算出一个f函数值
 * 
 * 而words的每个函数值都可以求出来，原本的值是什么并不重要
 * 
 * 然后再二分查找（转化为数字排序）
 * 
 * 再对于f函数 用桶计数很好做
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1170 {

	public static void main(String[] args) {
		LeetCode1170 s = new LeetCode1170();
		s.numSmallerByFrequency(new String[] { "bba" }, new String[] { "aaabbb", "aab", "babbab", "babbbb", "b",
				"bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa" });
	}

	/**
	 * 这个字问题的模型使用桶计数是最好的
	 * 
	 * 特征：数据量小 ，搜索最小数的数量
	 * 
	 * @param s
	 * @return
	 */
	public int f(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[] bucket = new int[26];
		for (char c : s.toCharArray())
			bucket[c - 'a']++;
		for (int num : bucket)
			if (num > 0)
				return num;

		return 0;
	}

	/**
	 * 
	 * 变种的二分查找类型
	 * 
	 * 查找比目标数字大的数字的数量 举例 0 1 2 3 4 5 6 7 8 9 查找 -1 3.5 4 4.5 10
	 * 
	 * 注意可能有重复数据
	 * 
	 * @param queryNum
	 * @param target
	 * @return
	 */
	public int binarySearch(int queryNum, int[] target) {
		int left = 0;
		int right = target.length - 1;
		int n = target.length;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			//相等right也向左移动
			if (target[mid] > queryNum)
				right = mid - 1;
			else {
				left = mid + 1;
			}

		}
		
		//现在的right之右都满足
		return n - 1 - right;
	}

	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] res = new int[queries.length];
		int[] target = new int[words.length];
		for (int i = 0; i < words.length; i++)
			target[i] = f(words[i]);

		// 转化为数字，二分查找前排序
		Arrays.sort(target);

		// 对于每个数字分别寻找集合里比他小的数字数量
		for (int i = 0; i < queries.length; i++) {
			int queryNum = f(queries[i]);
			res[i] = binarySearch(queryNum, target);
		}
		return res;
	}

}
