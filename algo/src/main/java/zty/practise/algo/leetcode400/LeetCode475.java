package zty.practise.algo.leetcode400;

import java.util.Arrays;

/**
 * 
 * 举例构图分析
 * 
 * 对象应该是房屋；每个房屋找到其左右两边更近那个加热器的距离
 * 比较最大值
 * 
 * 需要先排序
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode475 {

	/**
	 * 这种双指针主要是细节的处理比较麻烦
	 * 
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses); 
        Arrays.sort(heaters);
        int max = 0;
        int temp = 0;
        //从头开始遍历两个数组，每次只有一个下标+1
        for (int i = 0, j = 0; i < houses.length && j < heaters.length; ) {
            if (houses[i] <= heaters[j]) {
                temp = heaters[j] - houses[i];
                i++;
            } else if (j < heaters.length - 1) {
                temp = Math.min(heaters[j+1] - houses[i], houses[i] - heaters[j]);
                if (houses[i] < heaters[j+1]) {
                    i++;
                } else {
                    j++;
                }
            } else if (j == heaters.length - 1) {
                temp = houses[i] - heaters[j];
                i++;
            }
            max = max > temp ? max : temp;
        }
        return max;
    }

}
