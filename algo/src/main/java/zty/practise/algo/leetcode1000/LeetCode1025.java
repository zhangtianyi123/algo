package zty.practise.algo.leetcode1000;

/**
 * 博弈
 * 双方每一步均采用最佳决策
 * 
 * 对于一个大数字N  什么样的决策才是最佳决策
 * 
 * 
 * 转变思路 自底向上
 * 
 * 1 总是可以选择的，对于偶数2总是可以选择的
 * 
 * 希望自己是2，4别人是1，3、
 * =>  6  |  5
 * =>  8  |  7
 * =>  10 |  9
 * =>  不严格的推论：先手遇到偶数胜  奇数败
 * 如果是6可以得到4
 * 
 * 小结：
 * 自顶向下分析是困难的
 * 自底向上的分析，一环扣一环的找出必胜的逻辑链条
 * 
 * 解法2：
 * 动态规划
 * 一般化的做法
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1025 {

	public boolean divisorGame(int N) {
        	return N % 2 == 0;
    }
	
	/**
	 * 对于dpn 如果其n-x存在有任意一个为负（这一手是要给对手的）
	 * 自己的必胜手就是存在给对手必负手的手
	 * 则胜
	 * 
	 * 对于一个必胜手，在符合规则的情况下，可能回有多个不同的决策机会
	 * 只要存在至少一个留给对手的必负手，那么在最优决策下，这就是个必胜手
	 * 
	 * @param N
	 * @return
	 */
	public boolean divisorGame2(int N) {
    	if(N==1)
    		return false;
    	if(N==2)
    		return true;
    	
    	boolean[] dp = new boolean[N+1];
    	dp[1] = false;
    	dp[2] = true;
    	
    	for(int i=3; i<=N; i++) {
    		dp[i] = false;
    		for(int j=1; j<i; j++) {
    			if(i % j == 0 && !dp[i-j]) {
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return dp[N];
	}
}
