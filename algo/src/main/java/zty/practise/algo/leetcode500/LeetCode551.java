package zty.practise.algo.leetcode500;

/**
 * 题很简单，第二种写法简单的多，主要是循环里if中的下标限定
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode551 {

	public boolean checkRecord(String s) {
		if (s == null)
			return true;

		char[] cs = s.toCharArray();
		if (cs.length < 2)
			return true;

		char first = cs[0];
		int countA = 0;
		int countL = 0;

		if (first == 'A')
			countA++;
		else if (first == 'L')
			countL++;

		for (int i = 1; i < s.length(); i++) {
			if (cs[i] == 'A') {
				countA++;
				if (countA == 2)
					return false;
			}

			if (cs[i] == 'L') {
				if (cs[i - 1] == 'L') {
					countL++;
					if (countL == 3)
						return false;
				} else {
					countL = 1;
				}
			}
		}

		return true;
	}

	public boolean checkRecord2(String s) {
		int countA = 0;
		for (int i = 0; i < s.length() && countA < 2; i++) {
			if (s.charAt(i) == 'A')
				countA++;
			if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
				return false;
		}
		return countA < 2;
	}

}
