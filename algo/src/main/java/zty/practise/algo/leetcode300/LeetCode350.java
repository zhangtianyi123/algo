package zty.practise.algo.leetcode300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数据集的搜索，搜索的判断条件是相等
 * 
 * 不排序的话 最基本的搜索方式需要n*m范围的搜索
 * 
 * 因为不排序的数据集的数据之间没有相关性 任何一个数字在另一个集合都有可能出现或者不出现
 * 而排序的本质是建立前后数据之间的关联，从而能对搜索进行剪枝
 * 双指针动态移动，动态减小搜索区间
 * 
 * 解法三:
 * 因为在意的是数字的存在而非顺序
 * 所以可以使用空间来优化时间使用hashmap统计每个字母出现的次数
 * （检查数组的大小并对较小的数组进行哈希映射是一个小细节，当其中一个数组较大时，会减少内存的使用。）
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> res = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i] == nums2[j]) {
				res.add(nums1[i]);
				i++;
				j++;
			} else if(nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
			
		}
		
		return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
