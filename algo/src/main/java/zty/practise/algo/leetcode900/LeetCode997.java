package zty.practise.algo.leetcode900;

import java.util.HashSet;
import java.util.Set;

/**
 * 信息的转化和整理
 * 
 * 可以看作是图的节点的入度和出度
 * 
 * 存在且仅存在一个出度为n-1且入度为0的节点
 * 
 * 因为trust[i]规定了是完全不同的，所以可以不用使用set去重
 * 否则可以对Set<Integer> (trust[0] * 10 + trust[1]) 去重
 * 
 * 因为是不同的，所以只需要统计有多少，而不用统计是什么
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode997 {

	public int findJudge(int N, int[][] trust) {
		int[] in = new int[N+1];
		int[] out = new int[N+1];
		
		for(int i=0; i<trust.length; i++) {
			in[trust[i][1]]++;
			out[trust[i][0]]++;
		}
		
		int res=0;
		int fg = 0;
		for(int i=1; i<=N; i++) {
			if(in[i] == N-1 && out[i]==0) {
				res++;
				fg = i;
			}
		}
		
		return res==1?fg:-1;
	}
	    
}
