package zty.practise.algo.leetcode1300;

import java.util.Random;

/**
 * 搜索
 * 
 * 不含零这个事情本身 是否含有数学规律呢
 * 
 * 那就比
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1317 {

	 public int[] getNoZeroIntegers(int n) {
	        Random random = new Random();
	        int a = random.nextInt(n);
	        int b = n - a;
	        while (hasZero(a) || hasZero(b)) {
	            a = random.nextInt(n);
	            b = n - a;
	        }
	        int[] res = new int[2];
	        res[0] = a;
	        res[1] = b;
	        return res;
	    }

	    boolean hasZero(int n) {
	        String s = String.valueOf(n);
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '0') {
	                return true;
	            }
	        }
	        return false;
	    }
}
