package zty.practise.algo.leetcode000;

public class LeetCode066 {

    public int[] plusOne(int[] digits) {
    	for(int i=digits.length - 1; i>=0; i--) {
    		if(digits[i] != 9) {
    			digits[i]++;
    			break;
    		} else {
    			digits[i] = 0;
    		}
    	}
    	
    	if(digits[0] != 0)
    		return digits;
    	
    	int[] res = new int[digits.length + 1];
    	for(int i=0; i<digits.length; i++) {
    		res[i+1] = digits[i];
    	}
    	res[0] = 1;
    	return res;
    }
}
