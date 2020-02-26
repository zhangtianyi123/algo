package zty.practise.algo.leetcode300;

/**
 * 可以使用整数解法
 * 
 * 因为4存在二进制规律 也可以使用位运算解法
 * 
 * 0x为十六进制的前缀标识，0位八进制的前缀标识，十进制没有前缀标识
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode342 {

	/**
	 * (101010...10)  用十六进制表示为 ：(aaaaaaaa) 
	 * 
	 * 检查num为2的并且 1出现在奇数位
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPowerOfFour(int num) {
		return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
	}

}
