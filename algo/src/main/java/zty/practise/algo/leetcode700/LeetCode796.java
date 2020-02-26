package zty.practise.algo.leetcode700;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 可以使用KMP
 * 
 * 简单一点可以使用hash算法
 * 
 * 如果两个字符串哈希值相同，两个字符串很可能相同
 * 
 * hash(S) = (S[0] * P^0 + S[1] * P^1 + S[2] * P^2 + ...) % MOD
 * S[i]代表S中第i个字母的ASCII编码值
 * 
 * A[0], A[1], ..., A[N - 1] 的哈希值
 * 经过旋转操作
 * A[1], A[2], ..., A[N - 1], A[0] 的哈希值，这可以通过将 hash(A) 减去 A[0]，除以 P，
 * 再加上 A[0] * P^(N - 1) 得到。
 * 
 * 其中除以 P 的操作是在对 MOD 取模的意义下的，等价于乘以 P 的乘法逆元。如果 MOD 为质数，
 * P 的乘法逆元 Pinv 为 P^(MOD - 2) 对 MOD 取模的结果。这可以根据费马小定理推导出
 * 
 *  
 *  
 * 进制型的哈希算法有个热点 相邻两个子串的哈希值的计算公式有一定的关系
 * 
 * 取模注意点 不能使用Math.pow(26,  n)  可能直接就越界了，比如每次*26 就取模一次
 * 
 * 可以缓存26的n次方值 提升性能
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode796 {
	
	public boolean rotateString4(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

	
	public static void main(String[] args) {
		LeetCode796 s = new LeetCode796();
		s.rotateString("bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy", "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze");
	}
	
	/**
	 * 避免取模的除法  其实左移动右移动是一样的
	 * 
	 * (a + b) % p = (a%p + b%p) %p
	 * (a - b) % p = ((a%p - b%p) + p) %p
	 * (a * b) % p = (a%p)*(b%p) %p
	 * 
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean rotateString(String A, String B) {
		if (A.equals(B)) 
        	return true;

        int n = B.length();
        if(n != A.length())
        	return false;
        
        //质数
        long MOD = 1000000007;
        
        long hashB = 0;
        long p = 1;
        for (char x : B.toCharArray()) {
        	long t = ((x - 'a') * p % MOD) % MOD;
        	hashB = (hashB + t % MOD) % MOD;
        	p = (p % MOD * 26) % MOD;
        }
        
        long hashA = 0;
        long pa = 1;
        for (char x : A.toCharArray()) {
        	long t = ((x - 'a') * pa % MOD) % MOD;
        	hashA = (hashA + t % MOD) % MOD;
        	pa = (pa % MOD * 26) % MOD;
        }
        
        char[] ca = A.toCharArray();
        long prehash = hashA;
        for (int i = 0; i < ca.length; ++i) {
            char x = ca[n-1-i];
            long sub = (long) ((x - 'a') * get26(n-1, MOD) % MOD) % MOD;
            long curhash = ((((prehash % MOD) - (sub % MOD) + MOD) % MOD * 26) % MOD + (x - 'a')) % MOD;
            prehash = curhash;
            
            if (curhash == hashB && (A.substring(n-1-i) + A.substring(0, n-1-i)).equals(B))
                return true;
        }
        
        return false;
	}
	
	private long get26(int n, long MOD) {
		long res = 1;
		for(int i=0; i<n; i++) {
			res =  (res * 26) % MOD;
		}
		return res;
	}
	
	public boolean rotateString3(String A, String B) {
		if (A.equals(B)) 
        	return true;

        int n = B.length();
        if(n != A.length())
        	return false;
        
        long hashB = 0;
        int p = 1;
        for (char x : B.toCharArray()) {
        	long t = (x - 'a') * p;
        	hashB = hashB + t;
        	p *= 26;
        }
        
        long hashA = 0;
        int pa = 1;
        for (char x : A.toCharArray()) {
        	long t = (x - 'a') * pa;
        	hashA = hashA  + t;
        	pa *= 26;
        }
        
        char[] ca = A.toCharArray();
        long prehash = hashA;
        for (int i = 0; i < ca.length; ++i) {
            char x = ca[n-1-i];
            long sub = (long) ((x - 'a') * Math.pow(26, n-1));
            long curhash = ((prehash - sub) * 26) + (x - 'a');
            prehash = curhash;
            
            if (curhash == hashB && (A.substring(n-1-i) + A.substring(0, n-1-i)).equals(B))
                return true;
        }
        
        return false;
	}

	public boolean rotateString2(String A, String B) {
        if (A.equals(B)) 
        	return true;

        //质数
        int MOD = 1000000007;
        //质数
        int P = 113;
        //P的乘法逆元
        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

        
        //利用“进制法”求取hash值
        long hb = 0, power = 1;
        for (char x: B.toCharArray()) {
            hb = (hb + power * x) % MOD;
            power = power * P % MOD;
        }

        long ha = 0; power = 1;
        char[] ca = A.toCharArray();
        for (char x: ca) {
            ha = (ha + power * x) % MOD;
            power = power * P % MOD;
        }

        for (int i = 0; i < ca.length; ++i) {
            char x = ca[i];
            ha += power * x - x;
            ha %= MOD;
            //基于模的除法相当于乘上乘法逆元
            ha *= Pinv;
            ha %= MOD;
            //抛开对于模除法
            //这里其实是核心的算法思想，先比较hash值 再全量比较
            if (ha == hb && (A.substring(i+1) + A.substring(0, i+1)).equals(B))
                return true;

        }
        return false;
    }

}
