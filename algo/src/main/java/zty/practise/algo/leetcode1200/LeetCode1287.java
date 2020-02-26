package zty.practise.algo.leetcode1200;


/**
 * 考虑极端情况，最前四分之一，最后四分之一
 * 
 * 【|  |  |  |  |】
 * 五个点
 * 如果长度超过四分之一 那么有且只有一个数字在两个相邻点以上都相同
 * 
 * 解法2：遍历
 * 
 * 解法3： 二分查找
 * ...
 * 
 * 任意相隔1/4总长的两个点相等即是答案
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1287 {
	
	public int findSpecialInteger(int[] arr) {
        int threshold = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i + threshold] == arr[i]) {
                return arr[i];
            }
        }
        return 0;
    }
}
