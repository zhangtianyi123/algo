package zty.practise.algo.leetcode200;

/**
 * 除了整数运算之外
 * 
 * 还有一种方案是二进制的位运算
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode231 {

	public boolean isPowerOfTwo(int n) {
		if (n == 0) 
			return false;
		
        while(n % 2 == 0) {
        	n = n / 2;
        }
        
        return n==1;
    }	
	
	
	public boolean isPowerOfTwo2(int n) {
	    if (n == 0) 
	    	return false;
	    
	    long x = (long) n;
	    return (x & (x - 1)) == 0;
	 }
}
