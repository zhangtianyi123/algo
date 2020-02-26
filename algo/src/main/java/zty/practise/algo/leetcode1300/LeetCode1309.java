package zty.practise.algo.leetcode1300;

/**
 * for + if就处理了
 * 只不过觉得倒着更好处理些
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1309 {
	
	public static void main(String[] args) {
		LeetCode1309 s = new LeetCode1309();
		s.freqAlphabets("10#11#12");
	}

	public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
        	int num = -1;
        	if(s.charAt(i) == '#') {
        		i -= 2;
        		num += Integer.valueOf(s.substring(i, i+2));
        	} else {
        		num += Integer.valueOf(s.substring(i, i+1));
        	}
        	sb.append((char)('a' + num));
        }
        
        return sb.reverse().toString();
    }
}
