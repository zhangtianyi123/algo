package zty.practise.algo.leetcode600;

/**
 * 通过举例分类讨论（奇数长度和偶数长度）发现
 * 
 * 如果本身是回文数那么一定存在至少一种方案删除一个还是回文数（删除中间的数）
 * 
 * 这个题目就是要寻求至少一种方案，能不饿能不通过白能力模拟删除每个字符来做呢？
 * 
 * 那就要给予字符串的关系本身
 * 
 * 举例  a c c b b c a  可以理解为删除的是第二个c 而不是第三个 那么就可以从外到内遇到相同的就跳过
 * 
 * 
 * 逆向思维  在回文串中加入一个任意的数
 * 分类讨论 画图
 * 
 *   【   【   x  【    【  】     】          】      】 
 *   
 *   【   【        【    【  】     】   x   】      】 
 *   
 *   如上找到第一个不相同的，要么[x, y-1] 要么 [x+1 , y]为回文串则成立
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode680 {

    public boolean validPalindrome(String s) {
        if(s == null || s.length() < 2) {
        	return true;
        }
        
        int i = 0;
    	int j = s.length()-1;
    	
    	while(i < j) {
    		if(s.charAt(i) != s.charAt(j)) {
    			return idPalindrome(s.substring(i+1, j+1)) || idPalindrome(s.substring(i, j));
    		} else {
    			i++;
        		j--;
    		}
    	}
    	
    	return true;
    }
    
    private boolean idPalindrome(String s) {
    	if(s == null)
    		return true;
    	
    	int i = 0;
    	int j = s.length()-1;
    	
    	while(i < j) {
    		if(s.charAt(i) != s.charAt(j))
    			return false;
    		
    		i++;
    		j--;
    	}
    	
    	return true;
    }
}
