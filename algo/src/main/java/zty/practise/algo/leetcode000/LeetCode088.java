package zty.practise.algo.leetcode000;

/**
 * merge算法
 * 
 * 如果是空间merge 那么双指针就可以了
 * 
 * 但是这是原地merge,其实也有空间，在数组1 的后面
 * 
 * 从这一点入手，我们倒着来
 * 
 * 注意处理其中一者结束的场景
 * （举例子）
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode088 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m + n - 1;
		m--; 
		n--;
		for(int i=k; k>=0; k--) {
			//数组2走完可以直接结束了
			if(n < 0)
				break;
			
			//数组1 走完 仍然需要移动数组2 剩余的
			if(m < 0 || nums1[m] <= nums2[n]) {
				nums1[k] = nums2[n];
				n--;
			} else {
				nums1[k] = nums1[m];
				m--;
			}
		}
    }
}
