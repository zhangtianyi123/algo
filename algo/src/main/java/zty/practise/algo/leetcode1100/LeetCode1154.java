package zty.practise.algo.leetcode1100;

/**
 * 其实抛开题目来说
 * 这是一个有点实际用处的小程序
 * 
 * 每个月的天数不等
 * 如果是闰4  那么2月天数+1
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1154 {

	public int dayOfYear(String date) {
		int year = Integer.valueOf(date.substring(0, 4));
		int month = Integer.valueOf(date.substring(5, 7));
		int day = Integer.valueOf(date.substring(8, 10));
		
		int[] ms = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		int res = 0;
		for(int i=1; i<month; i++) {
			res += ms[i-1];
		}
		res+=day;
		return year % 4==0 && year % 100 != 0 && month > 2 ? res+1 : res;  
    }
}
