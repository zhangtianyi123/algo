package zty.practise.algo.leetcode600;

/**
 * 
 * 模拟遍历的性能显然是很差的
 * 
 * 那么要避免这种情况，就需要找到规律
 * 
 * 举例   abcd  cdabcdab
 * 
 * 关注一头一尾  n = x + 1(如果有不完整的头) + 1（如果有不完整的尾）
 * 
 * 所以尝试正向思维和逆向思维
 * 
 * 正向思维是通过B作为主串 去查找子串A
 * 
 * 而逆向思维是通过A的组装，去查找子串B 
 * 
 * 由上面的分析可知  A最多组装到 B.length / A.length + 2
 * 
 * 
 * 补充想到的剪枝: na一定是要长于等于B才可能包含B的  nA小于B的情况可以剪掉
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode686 {

	public int repeatedStringMatch(String A, String B) {
        int count = 1;
        int n = B.length() / A.length() + 2;
        String nA = A;
        
        while(n-- > 0) {
        	if(nA.length() >= B.length() && nA.indexOf(B) != -1) {
        		break;
        	} else {
        		nA += A;
        		count++;
        	}
        }
        
        if(nA.indexOf(B) == -1)
        	return -1;
        
        return count;
    }
}
