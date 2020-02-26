package zty.practise.algo.leetcode1100;

/**
 * 
 * 方案1: 类似一般排序算法的思想
 * 
 * 分为arr2.length论，每轮处理一个元素
 * 
 * 用两个指针，交换，但是会导致不稳定排序
 * 
 * 揭发二，利用数值上限，采用桶排序或者计数排序
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1122 {

	/**
	 * 以图形化的方式来理解
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] m = new int[1001];

		int[] ref = new int[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			m[arr1[i]]++;
		}

		int cnt = 0;
		for (int i = 0; i < arr2.length; i++) {
			while (m[arr2[i]] > 0) {
				ref[cnt++] = arr2[i];
				m[arr2[i]]--;
			}
		}

		for (int i = 0; i < 1001; i++) {
			while (m[i] > 0) {
				ref[cnt++] = i;
				m[i]--;
			}
		}
		return ref;
	}

	/**
	 * 不稳定的排序 有bug
	 * 
	 * 如果不在乎其他元素的相对顺序就是可以的
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int[] relativeSortArray2(int[] arr1, int[] arr2) {

		int j = 0;
		for (int i = 0; i < arr2.length; i++) {
			int val = arr2[i];
			int k = 0;
			while (k < arr1.length) {
				if (arr1[k] == val) {
					// 交换导致不稳定
					int t = arr1[j];
					arr1[j] = arr1[k];
					arr1[k] = t;

					k++;
					j++;
				} else {
					k++;
				}
			}
		}

		return arr1;
	}
}
