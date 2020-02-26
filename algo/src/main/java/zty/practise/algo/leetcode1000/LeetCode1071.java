package zty.practise.algo.leetcode1000;

/**
 * 如果A和B有公因子
 * 
 * 那么举例
 * 
 * ABABAB  ABAB
 * 
 * 如果具备最小公因子，那么
 * ABABAB * 2 = ABAB * 3
 * 
 * 首先通过这个方式确定是否存在解
 * A + B = B + A
 * 
 * 在存在解的情况下
 * 考虑数学方式，通过长度的关系，来确定最长公因子字符串的长度
 * 
 * 解法2 ： 不断模拟拼接比较（非数学方式）
 * 动态的StringBuilder比较
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1071 {

	/**
	 * ABABABAB  ABAB
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String gcdOfStrings(String str1, String str2) {
		if(!(str1 + str2).equals(str2 + str1))
			return "";
		
		return str1.substring(0,gcd(str1.length(),str2.length()));
    }
	/**
	 * 数学方式，辗转相除法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
    private int gcd(int a,int b){
        if(a == 0){
            return b;
        }
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

}
