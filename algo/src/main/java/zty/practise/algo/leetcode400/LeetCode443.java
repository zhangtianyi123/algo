package zty.practise.algo.leetcode400;

/**
 * 
 * 题目应该忘记了描述有序
 * 
 * 有序的话关键就是在字符变化的那个点了
 * 
 * 原地操作的话 直观的想法就是读写双指针
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode443 {

	public int compress(char[] chars) {
		int writePos = 0;
		int preReadPos = -1;
		for(int readPos=0; readPos < chars.length; readPos++) {
			if(readPos == chars.length-1 || chars[readPos] != chars[readPos + 1]) {
				chars[writePos++] = chars[readPos];
				char[] counts = ((readPos - preReadPos) + "").toCharArray();
				if(counts.length > 1 || counts[0] != '1') {
					for(char c : counts) {
						chars[writePos++] = c;
					}
				}
				preReadPos = readPos;
			}
		}
		
		return writePos;
    }
	
	
	public static void main(String[] args) {
		LeetCode443 s = new LeetCode443();
		char[] cs = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		s.compress(cs);
	}
}
