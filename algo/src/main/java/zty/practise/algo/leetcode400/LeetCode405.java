package zty.practise.algo.leetcode400;

/**
 * 
 * 0 1 2 ...  10 11 12 13 14 15
 * 0 1 2 ...  a  b  c  d  e  f
 * 
 * 求负整数的补码，将其原码除符号位外的所有位取反（0变1，1变0，符号位为1不变）后加1
 * 0正 1负
 * 
 * -1 : 1111-1111-...-1111  -> ffffffff?  4*8 =32 每四个二进制位组成一个十六进制位
 * 
 *    位运算
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode405 {
	public String toHex(int num) {
		String table = "0123456789abcdef";
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			int p = num & 15;
			sb.append(table.charAt(p));
			//无符号右移
			num >>>= 4;
		}
		
		return sb.length() != 0 ? sb.reverse().toString() : "0";
	}
}
