package zty.practise.algo.leetcode100;

/**
 * 整数进制罢了
 * 以26为一个循环 按位处理
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode168 {

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int reminder = n % 26;
            if (reminder == 0) {
                reminder = 26;
                //边界处理，比如传入n=26 结果应该是Z
                //这里如果不减去26  26/26=1 > 0 还会再次进入循环
                n -= 26;
            }
            sb.insert(0, (char) ('A' + reminder - 1));
            n /= 26;
        }
        return sb.toString();
	}
}
