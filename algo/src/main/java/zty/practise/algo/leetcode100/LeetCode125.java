package zty.practise.algo.leetcode100;

/**
 * 
 * 直接对比即可  双指针
 * 
 * Java有原生的库函数判断
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) 
            	i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) 
            	j--;
            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
            	return false;
            
            i++; 
            j--;
        }
        return true;
    }
}
