package zty.practise.algo.leetcode500;

import java.util.Arrays;

/**
 * 叠加效果
 * 
 * 有利点在于左上角都是0，0
 * 
 * 画图 举例
 * 
 * 找规律
 * 选定一边为基准
 * 
 * 
 * 比如  1 2 3 / 1 2 3
 * 
 * 1.1 +3   1,2+ 2  1,3 + 1
 * 
 * 相比于实际操作，只是返回个数就很简单了
 * mina * minb即可
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode598 {

	public int maxCount(int m, int n, int[][] ops) {
		int len = ops.length;
		int mina = Integer.MAX_VALUE;
		int minb = Integer.MAX_VALUE;
		
		for(int i=0; i<len; i++) {
			mina = mina < ops[i][0] ? mina : ops[i][0];
			minb = minb < ops[i][1] ? minb : ops[i][1];
		}
		
		return len == 0 ? 0 : mina * minb;
    }
}
