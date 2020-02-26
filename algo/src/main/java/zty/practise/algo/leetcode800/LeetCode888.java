package zty.practise.algo.leetcode800;

import java.util.Arrays;

/**
 * 相当于A减去两倍的某个数 = B减去两倍的某个数(这个转化仍然是不够直观的
 * SUMA SUMB是常数  最好是能够找到 X Y 两个数之间的数学关系，就可以使用
 * 1 双指针查找法（基于排序
 * 2 空间查找法（转化为查找一个））)
 * 
 * sumA - 2x = sumB - 2y
 * => y - x = (sumA - sumB) / 2  两个不定的变量  动态双指针
 * => y = x + (sumA -sumB) / 2   指定一个，查找另一个【存在性查找】，转化为查找问题，一般使用二分，但是因为复用不同y 可以使用hashset 空间换取时间
 * 
 * 暴力搜索的话  n * m 的复杂度
 * 
 * 不排序的话可能是不能缩小搜索空间的
 * 
 * 排序 双指针
 * 
 * 【数学】
 * y = x + (SA + SB) / 2
 * 转化为了【存在性问题！】 可以通过set辅助
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode888 {

	/**
	 * 时间算法
	 * 双指针【查找】
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] fairCandySwap(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int suma = 0;
		int sumb = 0;
		for(int e : A) {
			suma += e;
		}
		
		for(int e : B) {
			sumb += e;
		}
		
		int i = 0;
		int j = 0;
		int dif = (suma - sumb) / 2;
		while(A[i] - B[j] != dif) {
			if(A[i] - B[j] > dif) {
				j++;
			} else {
				i++;
			}
		}
		
		return new int[] {A[i], B[j]};
	}
}
