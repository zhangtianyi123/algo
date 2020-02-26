package zty.practise.algo.leetcode1200;

public class LeetCode1221 {

	/**
	 * 这个题比较简单 没啥
	 * 和异或解决唯一不重复数字的比较像吧
	 * 
	 * @param s
	 * @return
	 */
	public int balancedStringSplit(String s) {
        int count = 0;
        char[] cs = s.toCharArray();
        int tmp = 0;
        for(char c : cs) {
        	if(c == 'R')
        		tmp++;
        	else
        		tmp--;
        	
        	if(tmp == 0)
        		count++;
        }
        
        return count;
    }
}
