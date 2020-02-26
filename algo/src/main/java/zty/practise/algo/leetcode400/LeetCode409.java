package zty.practise.algo.leetcode400;

/**
 * 转化问题
 * 
 * 柱状图（桶计数）
 * 
 * 很快就想清楚了
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode409 {

	public int longestPalindrome(String s) {
        int[] a = new int[26];
        int[] A = new int[26];
        
        boolean flag = false; 
        for(char c : s.toCharArray()) {
        	if(c > 'Z') {
        		a[c - 'a']++;
        	} else {
        		A[c - 'A']++;
        	}
        }
        
        int res = 0;
        for(int n : a) {
        	if(n > 0) {
        		if(n % 2 == 0) {
        			res += n;
        		} else {
        			res += n - 1;
        			flag = true;
        		}
        	}
        }
        
        for(int n : A) {
        	if(n > 0) {
        		if(n % 2 == 0) {
        			res += n;
        		} else {
        			res += n - 1;
        			flag = true;
        		}
        	}
        }
        
        return res + (flag ? 1 : 0);
    }
}
