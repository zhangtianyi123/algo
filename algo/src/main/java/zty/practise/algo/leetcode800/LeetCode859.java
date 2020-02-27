package zty.practise.algo.leetcode800;

/**
 * 搜索问题
 *
 * 解决方案搜索- 存在性搜索
 * 
 * 首先是长度相等
 * 
 * 其次是如果全等，则看是否存在重复字母
 * 如果不是全等，则看是否只有两个位置不等且能互相交换 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode859 {
	
	public static void main(String[] args) {
		LeetCode859 s = new LeetCode859();
		s.buddyStrings("aa", "aa");
	}

	public boolean buddyStrings(String A, String B) {
		if(A.length() < 2 || B.length() < 2 || A.length() != B.length()) {
			return false;
		}
		
		//有无数据出现两次
		boolean hasTwice = false;
		boolean isCircle = false;
		int noEqualNum = 0;
		boolean[] bucket = new boolean[26];
		char a = '0';
		char b = '0';
		
		for(int i=0; i<A.length(); i++) {
			if(A.charAt(i) != B.charAt(i)) {
				noEqualNum++;
				if(noEqualNum == 1) {
					a = A.charAt(i);
					b = B.charAt(i);
				} else if(noEqualNum == 2) {
					isCircle = b == A.charAt(i) && a == B.charAt(i);
				}
				
			}
			if(!hasTwice) {
				if(bucket[A.charAt(i) - 'a']) {
					hasTwice = true;
				}
				bucket[A.charAt(i) - 'a'] = true;
			}
		}
		
		return (noEqualNum == 2 && isCircle) || (noEqualNum == 0 && hasTwice);
    }
}
