package zty.practise.algo.leetcode5000;


/**
 * 
 * 这个题反向找最大就是了 
 * 
 * 很简单
 * 
 * 常数时间不可能更快
 * 
 * 而且-1压根就不用特殊处理 要有这种意识
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode5134 {

	public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1; i>=0; i--) {
        	int cur = arr[i];
        	arr[i] = max;
        	if(cur > max)
        		max = cur;
        	
        }
        
        return arr;
    }
}
