package zty.practise.algo.leetcode600;

import java.util.ArrayList;
import java.util.List;

/**
 * 一侧全是1 一侧全是0 （0 1 数量相等） 的字符串子串的数量
 * 
 * eg: 00110011 => 2 2 2 2 min(a, b)
 * 
 * 0011 计算一次 11 11 计算一次 0011 计算一次
 * 
 * 对于0011 结果就是min(len0, len1)
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode696 {

	/**
	 * 因为边界处理的麻烦
	 * 
	 * 0 -> n-2
	 * 可以考虑替换为
	 * 1 -> n-1
	 * 
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings(String s) {
		int pre = 0;
		int count = 1;
		int res = 0;
		if (s.length() < 2)
			return 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				res += Math.min(count, pre);
				pre = count;
				count = 1;
				//最后一位边界条件处理
				if (i == s.length() - 2) {
					res++;
					break;
				}
			} else {
				count++;
				//最后一位边界条件处理
				if (i == s.length() - 2) {
					res += Math.min(count, pre);
					break;
				}
			}
		}

		return res;
	}
	
}
