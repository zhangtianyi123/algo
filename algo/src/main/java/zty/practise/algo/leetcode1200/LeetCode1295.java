package zty.practise.algo.leetcode1200;

/**
 * 每个数字是独立的，之间的判断结果互不影响，没有任何关系
 * 
 *  那么对于每个数字怎么快速的获取位数，或者说直接判断位数的奇偶呢
 *  
 *  二进制位运算会起到帮助么？
 *  
 *  字符串方式当然也是简便的
 *  
 *  /数学方式  log10
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1295 {

	public int findNumbers(int[] nums) {
        int res=0;
        for(int i:nums){
            if(String.valueOf(i).length()%2==0){
                res++;
            }
        }

        return res;
    }

}
