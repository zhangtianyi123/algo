package zty.practise.algo.leetcode300;

import java.util.ArrayList;
import java.util.List;

/**
 * 首先一定要判断找出元音字母
 * 
 * 其次反转，如果不额外存储 就必须一边判断一边交换
 * 
 * 前后指针按照merge的思想 判断，交换就可以了
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode345 {
	public static Boolean isVowel(char ch) {
	    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
	            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
	}

	public String reverseVowels(String s) {
	    char[] letters = s.toCharArray();
	    int left = 0;
	    int right = letters.length - 1;

	    while (left < right) {
	        if (!isVowel(letters[left])) {
	            left++;
	        }
	        if (!isVowel(letters[right])) {
	            right--;
	        }
	        if (isVowel(letters[left]) && isVowel(letters[right])) {
	            char tmp = letters[left];
	            letters[left] = letters[right];
	            letters[right] = tmp;
	            left++;
	            right--;
	        }
	    }

	    return new String(letters);
	}

}
