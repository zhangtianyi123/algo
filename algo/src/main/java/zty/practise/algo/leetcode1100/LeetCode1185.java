package zty.practise.algo.leetcode1100;


/**
 * 从1971.1.1  开始
 * 
 * 1971年1月1日 星期五
 * 
 * 1 求得是当年的第多少天
 * 2 求得是第几年
 * 3 在对7取余
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1185 {

	public String dayOfTheWeek(int day, int month, int year) {
		int res = 0;
		for(int i = 1971 ;i < year; ++i){
            res += i%400 == 0 || (i % 4==0 && i % 100 != 0) ? 366: 365;
        }
		
		res += dayOfYear(year, month, day);
		String[] days =  new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; 
		
		res = res % 7;
		int now = (4 + res) % 7;
        
        return days[now];
	}
	
	public int dayOfYear(int year, int month, int day) {
		int[] ms = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		int res = 0;
		for(int i=1; i<month; i++) {
			res += ms[i-1];
		}
		res+=day;
		return (year%400 == 0 || (year % 4==0 && year % 100 != 0)) && month > 2 ? res+1 : res;  
    }
}
