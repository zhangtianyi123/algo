package zty.practise.algo.leetcode900;

/**
 * 第一时间想到双指针
 * 
 * a bb c aabbbcc
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode925 {

	public static void main(String[] args) {
		LeetCode925 s = new LeetCode925();
		s.isLongPressedName("alex", "aaleex");
	}

	public boolean isLongPressedName(String name, String typed) {
		if (name == null || typed == null || name.length() > typed.length())
			return false;
		int i = 0;
		int j = 0;

		for (; i < name.length(); i++) {
			char c = name.charAt(i);
			if (j >= typed.length() || c != typed.charAt(j))
				return false;

			if (i < name.length() - 1 && c != name.charAt(i + 1)) {
				while ((j < typed.length() - 1 && typed.charAt(j + 1) == typed.charAt(j)) || j == typed.length() - 1) {
					j++;
				}
			}

			j++;

		}

		return true;
	}
}
