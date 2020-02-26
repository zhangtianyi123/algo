package zty.practise.algo.leetcode1200;

import java.util.*;
/**
 * 抛开这个题目无谓的花哨之处不谈
 * 他本质上还是在搜索
 * 
 * 1 暴力
 * 2 二分查找
 * 3 利用递增条件——双指针
 * 
 * 数学证明（当然直觉是有帮助的）
 * 
 * x增加则y减少才可能找到答案
 * 
 * 有序函數是单调递增的  比如 + *  那么这个单调递增可以用于减小搜索区间
 * 
 * f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 * 5 = 2 + 3 
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1237 {

	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1;
        int y = z;
        
        List<List<Integer>> res = new ArrayList<>();
        while(x <= z && y >= 1) {
        	if(customfunction.f(x, y) == z) {
        		List<Integer> tmp = new ArrayList<>();
    			tmp.add(x);
    			tmp.add(y);
    			res.add(tmp);
        		x++;
        		y--;
        	} else if(customfunction.f(x, y) > z) {
        		y--;
        	} else {
        		x++;
        	}
        }
        
        return res;
    }
	
	static class CustomFunction {
		 public int f(int x, int y) {
			 return 0;
		 }
	}
}
