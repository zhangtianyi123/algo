package zty.practise.algo.leetcode000;

/**
 * 这个题相当于是数学了
 * 
 * 能否通过数学方式化简
 * 
 * 还是从里到外循环的按照表达式处理
 * 通分？
 * 
 * 递归的思想
 * 模拟迭代  分子分母互换
 * 
 * @author zhangtianyi
 *
 */
public class LeetCodeLCP2 {

	public int[] fraction(int[] cont) {
        int[] res = new int[2];
        res[0] = cont[cont.length - 1];
        res[1] = 1;
        for (int i = cont.length - 1; i > 0; i--) {
            int temp = res[0];
            res[0] = cont[i - 1] * res[0] + res[1];
            res[1] = temp;
        }
        return res;
    }

}