package zty.practise.algo.leetcode900;

import java.util.HashSet;
import java.util.Set;

/**
 * 有一个元素恰好占了一半 其它各不相同
 * 
 * 用空间当然很好做
 * 
 * 但是能不能不用空间呢
 * 
 * 比如排序是可以的
 * 
 * 但是如果不用排序 采用更直接的方式呢
 * 
 * 比较两两相邻的元素，如果相同则返回 如果比较完了都没有相同说明正好相间排列
 * 
 * 比较1234即可
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode961 {

	public int repeatedNTimes(int[] A) {
		for(int i=0; i<A.length-1; i++) {
			if(A[i] == A[i+1]) {
				return A[i];
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<4; i++) {
			if(set.contains(A[i])) {
				return A[i];
			}
			set.add(A[i]);
		}
		
		return -1;
    }
}
