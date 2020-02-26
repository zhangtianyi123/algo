package zty.practise.algo.leetcode1300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 这又是一道经典的搜索题
 * 
 * 搜索区间：1个
 * 搜索对象：两个
 * 搜索限制条件：两个数据两倍关系
 * 
 * 由于数字的值区间很大，没办法使用桶计数
 * 
 * 值相关的问题可以考虑排序，不然很难建立起任意两个数字之间的大小关系
 * 从而减小搜索区间
 * 
 * 双指针
 * 
 * 还有一个点 负数
 * 
 * 值相关的可以通过运算表达式转化为查找本身存不存在，可以结合空间  set
 * 
 * set的好处在于可以直接忽略顺序，排序再使用有点亏
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1346 {

	/**
	 * 正数负数分别采用不同的算法
	 * 
	 * @param arr
	 * @return
	 */
	public boolean checkIfExist(int[] arr) {
	    Arrays.sort(arr); 
	    
	    //负数和0使用set处理
	    Set<Integer> set = new HashSet<>();
	    //第一个正数的位置
	    int p = 0;
	    for (int i = arr.length - 1; i >= 0; i--) {
	        if (arr[i] > 0) {
	        	p = i;
	        	continue;
	        }
	        if (set.contains(arr[i])) 
	        	return true;
	        set.add(arr[i] * 2);
	    }
	    
	    //正数使用双指针的方式来解
	    int q = p + 1;
	    while(p < arr.length && q < arr.length) {
	    	if(arr[p] * 2  == arr[q]) {
	    		return true;
	    	} else if(arr[p] * 2 > arr[q]) {
	    		q++;
	    	} else {
	    		p++;
	    	}
	    }
	    
	    
	    return false;
	}
}
