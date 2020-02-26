package zty.practise.algo.leetcode000;

/**
 * 
 * 的第一想法是转为字符串反转之后转为数字
 * 
 * 但是靠哦v如果不用字符串的方式呢 就是一位一位的处理了
 * 
 * 因为是十进制，所以可以考虑通过除以10和模10得到前n-1为和最后一位
 * 
 * 先正常鞋写 不要依赖就考虑特殊情况 看看正常情况能否囊哭一场情况
 * 
 * 比如后导零 不用特殊处理，因为后导零肯定在最后，此时运算 res==0
 * 
 * 负数也不用特殊处理，举例-123
 * 
 * 唯一需要特殊处理的就是溢出。溢出可以根据Integer,MAX/MIN判断
 * 
 * res * 10 + last < Integer.MAX_VALUE
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode007 {

	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int last = x % 10;
			if (res > Integer.MAX_VALUE / 10 || ((Integer.MAX_VALUE / 10) == res && Integer.MAX_VALUE % 10 < last))
				return 0; 
			if (res < Integer.MIN_VALUE / 10 || ((Integer.MIN_VALUE / 10) == res && Integer.MIN_VALUE % 10 > last))
				return 0;

			x = x / 10;
			res = res * 10 + last;
		}

		return res;
	}

}
