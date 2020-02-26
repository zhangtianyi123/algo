package zty.practise.algo.leetcode1200;

/**
 * 求得各个位数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1281 {

	public int subtractProductAndSum(int n) {
        int a = 1;
        int b = 0;
        
        while(n > 0) {
        	int x = n % 10;
        	n = n / 10;
        	a = a * x;
        	b = b + x;
        }
        
        return a - b;
    }
}
