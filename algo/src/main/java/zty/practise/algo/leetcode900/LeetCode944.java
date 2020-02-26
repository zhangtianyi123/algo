package zty.practise.algo.leetcode900;

/**
 * 搞得花哨 其实就是找有多少个非降序
 * 存在降序对的数量
 * 
 * 各个列之间不存在关系
 * 过于简单？
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode944 {

	public int minDeletionSize(String[] A) {
        int res = 0;
        if(A.length == 0)
        	return 0;
        
        for(int i=0; i<A[0].length(); i++) {
        	for(int j=1; j<A.length; j++) {
        		if(A[j].charAt(i) < A[j-1].charAt(i)) {
        			res++;
        			break;
        		}
        	}
        }
        
        return res;
    }
}
