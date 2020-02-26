package zty.practise.algo.leetcode200;

import java.util.Arrays;

/**
 * 质数相关的问题
 * 算是基础编程题的比较经典的问题了
 * 
 * 在 [2,sqrt(n)] 这个区间之内没有发现可整除因子，就可以直接断定 n 是素数了，
 * 因为在区间 [sqrt(n),n] 也一定不会发现可整除因子
 * 
 * 举例： 12
 * 2 * 6
 * 3 * 4
 * 4 * 3  此处开始发生反转
 * 6 * 2
 *  
 * 排除法  2*3 2*4  ....   3*3 3*4...  5*5  为了避免重复从i*i开始即可
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode204 {

	public int countPrimes(int n) {
	    boolean[] isPrim = new boolean[n];
	    Arrays.fill(isPrim, true);
	    
	    //排除法 结合因子的对称性剪枝（考虑平方根范围内的素数因子即可）
	    for (int i = 2; i * i < n; i++) 
	        if (isPrim[i]) 
	        	//j是质数的倍数(质数的倍数可以用来筛选出合数)
	            for (int j = i * i; j < n; j += i) 
	                isPrim[j] = false;
	    
	    int count = 0;
	    for (int i = 2; i < n; i++)
	        if (isPrim[i])
	        	count++;
	    
	    return count;
	}

}
