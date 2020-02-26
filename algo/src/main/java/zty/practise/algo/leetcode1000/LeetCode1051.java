package zty.practise.algo.leetcode1000;

/**
 * 
 * 最直观的一种解法就是排序后对比计数每个位置的不同数量
 * 
 * 由于限制了大小 可以使用桶计数排序
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1051 {

	public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for(int height : heights) {
        	bucket[height]++;
        }
        
        int count = 0;
        int i = 1;
        int j = 0;
        while(i<101) {
        	while(bucket[i]-- > 0) {
        		if(i != heights[j++])
        			count++;
        	}
        	i++;
        }
        return count;
        
    }
}
