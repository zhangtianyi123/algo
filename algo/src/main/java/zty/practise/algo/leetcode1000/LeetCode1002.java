package zty.practise.algo.leetcode1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一反应就是桶计数
 * 
 * N个桶？ 遍历 
 * 搜索的范围可以不断缩小
 *  如果前面没有出现过，那么，后面一定不成立，不用搜索
 * 
 * 关键点在于可以动态的去取交集  而不用整个算出来各个单词之后再取交集
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1002 {

	public List<String> commonChars(String[] A) {
        int[] bucket = new int[26];
        
        for(char c : A[0].toCharArray()) {
        	bucket[c-'a']++;
        }
        
        for(int i=0; i<A.length; i++) {
        	int[] cur = new int[26];
        	for(char c : A[i].toCharArray()) {
            	cur[c-'a']++;
            }
        	
        	for(int j=0; j<26; j++) {
        		if(bucket[j] > cur[j]) {
        			bucket[j] = cur[j];
        		}
        	}
        }
        
        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++) {
        	while(bucket[i]-->0) {
        		res.add("" + (char)(i + 'a'));
        	}
        }
        
        return res;
    }
}
