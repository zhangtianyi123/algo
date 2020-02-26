package zty.practise.algo.leetcode1200;

import java.util.HashSet;
import java.util.Set;

/**
 * 根据限定采用桶计数
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1207 {

	public boolean uniqueOccurrences(int[] arr) {
		int[] a = new int[2001];
		
		for(int i : arr) {
			a[i+1000]++;
		}
		
		Set<Integer> set = new HashSet<>();
		
		for(int i : a) {
			if(i > 0) {
				if(set.contains(i))
					return false;
				else
					set.add(i);
			}
		}
		
		return true;
    }
}
