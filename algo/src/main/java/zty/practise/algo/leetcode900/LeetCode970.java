package zty.practise.algo.leetcode900;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode970 {

	/**
	 * 注意排除==1的情況  1的無限次方等于自身
	 * 
	 * @param x
	 * @param y
	 * @param bound
	 * @return
	 */
	 public List<Integer> powerfulIntegers(int x, int y, int bound) {
	        Set<Integer> set = new HashSet<>();
	        
	        for (int a = 1; a < bound; a *= x) {
	            for (int b = 1; a + b <= bound; b *= y) {
	                set.add(a + b);
	                if (y == 1) break;
	            }
	            if (x == 1) break;
	        }
	        
	        return new ArrayList<>(set);
	    }

	
	/**
	 * '
	 * 超出时间限制
	 * 
	 * @param x
	 * @param y
	 * @param bound
	 * @return
	 */
	public List<Integer> powerfulIntegers2(int x, int y, int bound) {
		Set<Integer> set = new HashSet<>();

		int a = x;
		int b = y;
		x = 1;
		y = 1;
		
		while (true) {
			int count = 0;
			while(x + y <= bound) {
				set.add(x + y);
				y *= b;
				count++;
			}
			x *= a;
            y = 1;
			if(count == 0)
				break;
		}
		
		return new ArrayList<Integer>(set);
	}
}
