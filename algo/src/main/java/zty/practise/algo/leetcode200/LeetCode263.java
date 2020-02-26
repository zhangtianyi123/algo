package zty.practise.algo.leetcode200;

/**
 * 
 * 初始值是 2 3 5
 * 
 * 每一步是乘法，可以选择的路径有三条 2 3 5
 * 
 * 是否可达？
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode263 {
	
	/**
	 * 自上而下
	 * 
	 * 疑惑  自上而下最大的问题是只有一条路径不会走错回溯吗
	 * 
	 * @param num
	 * @return
	 */
	public boolean isUgly(int num) {
        if(num == 0){
            return false;
        }
        while (num != 1){
            if(num % 2 == 0){
                num /= 2;
                continue;
            }
            if(num % 3 == 0){
                num /= 3;
                continue;
            }
            if(num % 5 == 0){
                num /= 5;
                continue;
            }
            return false;
        }

        return true;
        
    }

	/**
	 * 自下而上
	 * 超出时间空间限制
	 * 
	 * @param num
	 * @return
	 */
	public boolean isUgly2(int num) {
		if(num < 1)
			return false;
		boolean[] mem = new boolean[num+1];
        return help(2, num, mem) | help(3, num, mem) | help(5, num, mem) | num == 1;
    }
	
	private boolean help(int n, int num, boolean[] mem) {
		if(n <= num)
			mem[n] = true;
		if(n > num)
			return false;;
		
		if(n == num) {
			return true;
		}
		
		boolean res = false;
		if(n * 2 >= num || !mem[n * 2]) {
			res |= help(n * 2, num, mem);
		} 
		
		if(n * 3 >= num ||!mem[n * 3]) {
			res |= help(n * 3, num, mem);
		} 
		
		if(n * 5 >= num ||!mem[n * 5]) {
			res |= help(n * 5, num, mem);
		} 
		
		return res;
	}
}
