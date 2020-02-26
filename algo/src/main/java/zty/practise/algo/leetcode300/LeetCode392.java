package zty.practise.algo.leetcode300;

/**
 * 第一反应是双指针，顺序查找
 * 
 * 结合二分查找？但是排序的消耗也相当之大
 * 当如果输入大量不同的s 而T相同的时候可以采用这种方式 达到新媳妇用的目的
 * 
 * 动态规划？
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode392 {

	/**
	 * 
	 * 
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence(String s, String t) {
		int i=0;
        int j=0;
        while(i < s.length()){
            while(j < t.length() && t.charAt(j) != s.charAt(i)) 
            	j++;
            if(j >= t.length()) 
            	return false;
            j++;
            i++;
        }
        return true;

    }
	
	/**
	 * dp[i][j]为s的从头开始到i的子字符串是否为t从头开始到j的子字符串的子序列
	 * 
	 * 当char[i]==char[j]时，则字符i一定是j的子序列，如果0~i-1子字符串是0~j-1子字符串的子序列，则dp[i][j]=true，所以dp[i][j] = dp[i-1][j-1]；
	 * 当char[i]!=char[i]时，即判断当前0~i子字符串是否是0~j-1的子字符串的子序列，即dp[i][j] = dp[i][j - 1]。如ab，eabc，虽然s的最后一个字符和t中最后一个字符不相等，但是因为ab是eab的子序列，所以ab也是eabc的子序列
	 * 初始化：空字符串一定是t的子字符串的子序列，所以dp[0][j]=true
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence2(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen) 
        	return false;
        if (sLen == 0) 
        	return true;
        
        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        //初始化
        for (int j = 0; j < tLen; j++) {
            dp[0][j] = true;
        }
        //dp
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sLen][tLen];
    }

}
