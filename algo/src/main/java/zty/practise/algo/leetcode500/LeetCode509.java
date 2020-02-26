package zty.practise.algo.leetcode500;

/**
 * 斐波那契数是一道简单而经典的题目
 * 基础的递归实现动态规划问题
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode509 {

	public int fib(int N) {
        if(N == 0)
        	return 0;
        if(N == 1)
        	return 1;
        
        return fib(N-1) + fib(N-2);
    }
	
	
	/**
	 * 记忆化
	 * 自底向上
	 * 
	 * @param N
	 * @return
	 */
	public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
      int[] cache = new int[N + 1];
      cache[1] = 1;

      for (int i = 2; i <= N; i++) {
          cache[i] = cache[i-1] + cache[i-2];
      }
      return cache[N];
    }
    
    /**
     * 使用缓存 不重复计算
     */
    private Integer[] cache = new Integer[31];

    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize2(N);
    }

    public int memoize2(int N) {
      if (cache[N] != null) {
          return cache[N];
      }
      cache[N] = memoize2(N-1) + memoize2(N-2);
      return memoize2(N);
    }

}
