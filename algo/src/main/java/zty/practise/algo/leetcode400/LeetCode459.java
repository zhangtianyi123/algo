package zty.practise.algo.leetcode400;

/**
 * 
 * 重复串的第一位一定是和整个串的第一位相等的
 * 
 * 问题在于重复串第一位相等可能成功但也可能失败
 * 
 * 第1到n/2位都可能
 * 
 * 举例 abcabcabc       
 * 
 * xx  xxx  xxxx
 * 
 * 通过长度进行了剪枝  但是总体来说性能还是比较慢
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode459 {
	public boolean repeatedSubstringPattern(String s) {
		for(int i=0; i<s.length() - 1; i++) {
			if(s.length() % (i+1) == 0 && isNSubString(s, s.substring(0, i+1), s.length() / (i+1))) {
				return true;
			}
		}
		
		return false;
    }
	
	private boolean isNSubString(String s, String sub, int n) {
		String res = "";
		for(int i=0; i<n; i++) {
			res = res + sub;
		}
		
		return s.endsWith(res);
	}
}
