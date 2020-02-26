package zty.practise.algo.leetcode800;

import java.util.ArrayList;
import java.util.List;

public class LeetCode830 {

	/**
	 * 关键是在遍历过程中如何存储信息，使用何种数据结构
	 * 
	 * 考虑
	 * 
	 * @param S
	 * @return
	 */
    public List<List<Integer>> largeGroupPositions(String S) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(S.length() < 3)
    		return res;
    	
    	int count = 1;
    	int start = 0;
		
    	for(int i=1; i<=S.length(); i++) {
    		if(i==S.length() || S.charAt(i) != S.charAt(i-1)) {
    			if(count > 2) {
    				List<Integer> tmp = new ArrayList<>();
    				tmp.add(start);
    				tmp.add(i-1);
    				res.add(tmp);
    			}
    			count = 1;
    			start = i;
    		} else {
    			count++;
    		}
    	}
    	
    	return res;
    }
}
