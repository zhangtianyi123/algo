package zty.practise.algo.leetcode1100;

/**
 * 按照既定规律执行
 * 
 * 是动态一步一步模拟？
 * 按照数学规律直接最后一步答案？
 * 
 * 假设能完整分发分轮数是x
 * 1+2+...+x = candies
 * 
 * 每一轮比上一轮多消耗n平方
 * 
 * 等差数列求和公式
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1103 {

	/**
	 * 直接暴力法
	 * 
	 * @param candies
	 * @param num_people
	 * @return
	 */
	public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int n = 0;
        while (candies > 0) {
            for (int i = 1; i <= num_people; i++) {
                arr[i - 1] += Math.min(candies, i + n * num_people);
                candies -= (i + n * num_people);
                if (candies <= 0) {
                    break;
                }
            }
            n++;
        }
        return arr;
    }
}
