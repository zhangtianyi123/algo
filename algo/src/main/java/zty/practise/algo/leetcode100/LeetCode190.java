package zty.practise.algo.leetcode100;

/**
 * 
 * 二进制考虑微操作
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode190 {

	public int reverseBits(int n) {
		int res = 0;
		//处理32位整数
        for(int i=0; i<32; i++){
            //取得最低位
            int last = n & 1;
            //直接把二进制的最低位安排到最终位置上 
            res = res + (last << (31-i));
            //update
            n = n >> 1;
        }
        return res;
    }
}
