package zty.practise.algo.leetcode000;

/**
 * 遇到空格就开始刷零并统计
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode058 {

	public static void main(String[] args) {
		LeetCode058 s = new LeetCode058();
		System.out.println(s.lengthOfLastWord("a"));
	}
	
	public int lengthOfLastWord(String s) {
		int res = 0;
		s = s.trim();
		for(char c : s.toCharArray()) {
			if(c == ' ') {
				res = 0;
			} else {
				res++;
			}
		}
		
		return res;
    }
}
