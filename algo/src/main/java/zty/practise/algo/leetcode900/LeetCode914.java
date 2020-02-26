package zty.practise.algo.leetcode900;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 这道题用空间来做好做
 * 
 * 形成了一个柱状图
 * 
 * 柱子最大公因数>1
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode914 {

	public boolean hasGroupsSizeX(int[] deck) {
        int[] arr = new int[10001];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<deck.length; i++) {
        	arr[deck[i]]++;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] > 1) {
        		min = Math.min(min, arr[i]);
        		list.add(arr[i]);
        	} else if(arr[i] == 1) {
        		return false;
        	}
        }
        
        for(int i=2; i<=min; i++) {
        	int j=0;
        	for(; j<list.size(); j++) {
        		if(list.get(j) % i != 0) {
        			break;
        		}
        	}
        	if(j == list.size())
        		return true;
        }
        
        return false;
    }
}
