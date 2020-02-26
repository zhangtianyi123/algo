package zty.practise.algo.leetcode500;

/**
 * 
 * 关键是要捋清楚边界情况 最好的方式就是举例子
 * 
 * 合并第二和第三种情况 (>=k 和 >= 2k)
 * 
 * 对于一开始就<k的情况先不要做特殊处理，险些通用的 ，看能不能避免单独处理边界
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode541 {

	public String reverseStr(String s, int k) {
		char[] cs = s.toCharArray();
		
		for(int i=0; i<s.length(); i+=k) {
			if(i + k > s.length()) {
				reverse(cs, i, s.length() - 1);
			} else {
				reverse(cs, i, i+k-1);
				i = i+k;
			}
		}
		
		return new String(cs);
		
		
	}
	
	private void reverse(char[] cs, int start, int end) {
		while (start < end) {
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }
	}
}
