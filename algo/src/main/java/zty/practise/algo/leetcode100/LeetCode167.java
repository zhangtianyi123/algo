package zty.practise.algo.leetcode100;

public class LeetCode167 {

	public static void main(String[] args) {
		LeetCode167 s = new LeetCode167();
		s.twoSum(new int[] {0, 0, 3, 4},  0);
	}
	/**
	 * 
	 * 双指针？ 不好操作可能需要回溯
	 * 
	 * 那么单指针+二分查找吧
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		
        for(int i=0; i<numbers.length-1; i++) {
        	int num = target - numbers[i];
        	if(num < numbers[i])
        		continue;
        	else {
        		int left = i+1;
        		int right = numbers.length-1;
        		while(left <= right) {
        			int mid = left + (right - left) / 2;
        			if(numbers[mid] == num) {
        				res[0]  = i + 1;
        				res[1] = mid + 1;
        				return res;
        			} else if(numbers[mid] > num) {
        				right = mid - 1;
        			} else {
        				left = mid + 1;
        			}
        		}
        	}
        }
		
        return res;
    }
}
