package zty.practise.algo.leetcode1100;

public class LeetCode1128 {

	/**
	 * 使用空间，可以使用计数的思想
	 * 
	 * 题目限定条件值<=9
	 * 
	 * @param dominoes
	 * @return
	 */
	public int numEquivDominoPairs(int[][] dominoes) {
        int[] a = new int[100];
        
        for(int i=0; i<dominoes.length; i++) {
        	if(dominoes[i][0] <= dominoes[i][1]) {
        		a[dominoes[i][0] * 10 + dominoes[i][1]]++;
        	} else {
        		a[dominoes[i][1] * 10 + dominoes[i][0]]++;
        	}
        }
        
        int sum = 0;
        for(int i=0; i<100; i++) {
        	if(a[i] > 1) {
        		sum += a[i] * (a[i] - 1) / 2;
        	}
        }
        
        return sum;
    }
}
