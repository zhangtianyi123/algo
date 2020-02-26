package zty.practise.algo.leetcode900;

import java.util.HashSet;
import java.util.Set;

/**
 * 人脑找出数学规律
 * 
 * 元形式（最简形式） * n  可以避免罗列比较所有情况
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        
        for(String email : emails) {
        	char[] cs = email.toCharArray();
        	StringBuilder sb = new StringBuilder();
        	
        	for(int i = 0; i<cs.length; i++) {
        		if(cs[i] == '@' || cs[i] == '+') {
        			break;
        		} else if(cs[i] != '.') {
        			sb.append(cs[i]);
        		} 
        	}
        	sb.append(email.substring(email.indexOf("@")));
        	set.add(sb.toString());
        }
        
        return set.size();
    }
}
