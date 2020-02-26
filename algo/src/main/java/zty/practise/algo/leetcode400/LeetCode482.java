package zty.practise.algo.leetcode400;

/**
 * 这道题的关键在于确定第一个分组到底留多少字符
 * 
 * 取余确定
 * 
 * 第一步：去除-加大写
 * 第二步：加-
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode482 {

	public String licenseKeyFormatting(String S, int K) {
        StringBuilder res = new StringBuilder();
        
        for(char c : S.toCharArray()) {
        	if(c != '-') {
        		res.append(Character.toUpperCase(c));
        	}
        }
        
        int n = res.length() % K;
        while(n < res.length()) {
        	if(n != 0) {
        		res.insert(n, '-');
        		n++;
        	}
        	n += K;
        }
        
        return res.toString();
    }
}
