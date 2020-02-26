package zty.practise.algo.leetcode1300;

/**
 * 从高位到低位就好了
 * 
 * 数字型处理方式  /  字符串处理方式
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1323 {
	
	public int maximum69Number (int num) {
		//最高位的6
		int highSix = 0;
        int old = num;
		int i=0;
		int flag  = 0;
		while(num > 0) {
			if(num % 10 == 6) {
				highSix = i;
				flag = 1;
			}
			num /= 10;
			i++;
		}
		
		return (int) (old + 3 * Math.pow(10, highSix) * flag);
    }
}
