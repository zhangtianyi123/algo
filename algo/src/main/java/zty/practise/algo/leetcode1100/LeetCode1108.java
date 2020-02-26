package zty.practise.algo.leetcode1100;

/**
 * 这个题，只是考察最基本的插入操作能力
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1108 {

	public String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();
		for(char c : address.toCharArray()) {
			if(c == '.') {
				sb.append('[');
				sb.append('.');
				sb.append(']');
			} else
				sb.append(c);
		}
		
		return sb.toString();
    }
}
