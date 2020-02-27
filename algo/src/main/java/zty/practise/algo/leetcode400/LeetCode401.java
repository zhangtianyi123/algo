package zty.practise.algo.leetcode400;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 搜索题
 * 
 * 搜索所有符合条件的结果
 * 
 * 小时分钟分开算
 * 
 * hourSum <= 11 minSum <= 59
 * 
 * 所以这个可以利用有序性在搜索中剪枝
 * 
 * 循环 / 递归回溯
 * 
 * 思考问题本质: 小时是一个十进制数字，分钟是一个十进制数字 而限定的是小时和分钟对应的二进制表示中的1的数量和
 *
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode401 {

	int[] hours = new int[] { 1, 2, 4, 8 };
	int[] mins = new int[] { 1, 2, 4, 8, 16, 32 };
	List<String> res = new ArrayList<>();
	List<Integer> hourList = new ArrayList<>();
	List<Integer> minList = new ArrayList<>();

	/**
	 * 
	 * 这个题相当于在区间取N点，分成N步，每一步之后的可选区间都是动态的
	 * 
	 * 虽然有简单解法。但是还是把暴力的递归回溯搜索给写出来了，虽然写的有点不美观
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LeetCode401 s = new LeetCode401();
		s.readBinaryWatch(2);
	}

	/**
	 * 由于有很多步 每一步都是不确定的 可以通过递归回溯暴力搜索
	 *
	 * 在 i - n的区间中选n个角标，如果符合则加入结果 每一层递归确定一个数
	 * 
	 * @param num
	 * @return
	 */
	public List<String> readBinaryWatch(int num) {
		for (int i = 0; i <= num; i++) {
			int j = num - i;
			// 小时亮i个灯，分钟亮j个灯
			if (i > 3 || j > 5) {
				continue;
			}
			hourList = new ArrayList<>();
			minList = new ArrayList<>();
			if (i == 0)
				hourList.add(0);
			else
				for (int p = 0; p <= 3; p++)
					find(i, p, 3, 0);

			if (j == 0)
				minList.add(0);
			else
				for (int k = 0; k <= 5; k++)
					find(j, k, 5, 0);

			for (int h : hourList) {
				for (int m : minList) {
					res.add(String.format("%d:%02d", h, m));
				}
			}

		}

		return res;
	}

	/**
	 * 在start到end的区间之内确定num个数字,所有选定数字之和为sum 每次选中区间内的第一个数字
	 * 
	 * @param num
	 * @param i
	 * @param n
	 */
	private void find(int num, int start, int end, int sum) {
		if (num <= 0 || start > end)
			return;

		// 小时
		if (end == 3) {
			sum += hours[start];
			if (sum < 12) {
				if (num == 1) {
					hourList.add(sum);
				}
			} else
				return;
		}
		// 分钟
		if (end == 5) {
			sum += mins[start];
			if (sum < 60) {
				if (num == 1) {
					minList.add(sum);
				}
			} else
				return;
		}

		// 在区域内顺序选定
		for (int i = start + 1; i <= end; i++) {
			find(num - 1, i, end, sum);
		}
	}

	/**
	 * bitCount实现的功能是计算一个（byte,short,char,int统一按照int方法计算）int,long类型的数值在二进制下“1”的数量。
	 * 
	 * @param num
	 * @return
	 */
	public List<String> readBinaryWatch2(int num) {
		List<String> times = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount(h) + Integer.bitCount(m) == num)
					times.add(String.format("%d:%02d", h, m));
			}
		}
		return times;
	}

}
