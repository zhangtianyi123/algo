package zty.practise.algo.leetcode1200;

/**
 * 
 * 多步动态变化
 * 
 * 因为是累加，影响是叠加的  不会相互抵消
 * 
 * 所以可以单独全部看x  单独看全部的y
 * 
 * x[n] = []
 * y[n] = []
 * 
 * 奇数 = 奇数加偶数
 * 
 * 所以x奇数 * y偶数 + x偶数 + y奇数
 * 
 * 此类题目找到数学规律总是比动态模拟更好的
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1252 {

	public int oddCells(int n, int m, int[][] indices) {
		int[] x = new int[n];
		int[] y = new int[m];
		
		for(int i=0; i<indices.length; i++) {
			x[indices[i][0]]++;
			y[indices[i][1]]++;
		}
		
		int xn = 0;
		int yn = 0;
		
		for(int e : x) {
			if(e % 2 == 0) {
				xn++;
			}
		}
		
		for(int e : y) {
			if(e % 2 == 0) {
				yn++;
			}
		}
		
		return xn * (m - yn) + (n - xn) * yn;
    }
}
