package zty.practise.algo.leetcode500;

import java.util.ArrayList;
import java.util.List;

/**
 * 直观的想法是使用map记录
 * 
 * 
 * 但是由于只寻找最值 所以 不存储也是可以的
 * 
 * 而且而已根据先后关系剪枝
 * 
 * 只存在一种情况可能更长，即坐标是交叉的，否则没有比较的意义
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode599 {

	public String[] findRestaurant(String[] list1, String[] list2) {
		int length = 2001;
		
		for(int i = 0; i<list1.length; i++) {
			for(int j = 0; j<list2.length; j++) {
				if(i + j >= length) {
					continue;
				}
				if(list1[i].equals(list2[j])) {
					if(length > i + j) {
						length = i + j;
					}
				}
			}
		}
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i<list1.length; i++) {
			for(int j = 0; j<list2.length; j++) {
				if(i + j == length && list1[i].equals(list2[j])) {
					list.add(list1[i]);
					continue;
				}
			}
		}
		
		
		return list.toArray(new String[list.size()]);
    }
}
