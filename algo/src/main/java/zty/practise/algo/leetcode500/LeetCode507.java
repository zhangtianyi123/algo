package zty.practise.algo.leetcode500;

/**
 * 举例子
 * 
 * 寻找数学规律
 * 
 * 或者就是美剧，但是可以限定小于平方根的范围
 * 
 * @author zhangtianyi
 */
public class LeetCode507 {

	public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;
    }
}
