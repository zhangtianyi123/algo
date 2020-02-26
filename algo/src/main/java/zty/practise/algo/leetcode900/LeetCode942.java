package zty.practise.algo.leetcode900;

/**
 * 这个题还有几分意思
 * 
 * 看似两两关联 但是所有数字之间都形成了间接影响的关系
 * 
 * 注意连续的I D
 * 
 * 注意答案可能有多种 但是程序需要按照某种策略来放
 * 
 * ID 分开处理
 * 
 * 双指针
 * 
 * 举例：
 * IDID
 * 04132
 * 
 * I从0开始 一定合法  D从N开始也一定合法
 * 
 * 
 * @author zhangtianyi  
 * 
 *
 */
public class LeetCode942 {

	public int[] diStringMatch(String S) {
		int n = S.length();
		int[] res = new int[n+1];
		int index = 0;
		
		int x = 0;
		int y = n;
		
		for(int i=0; i<S.length(); ) {
			while(index<=n && i<S.length() && S.charAt(i) == 'I') {
				res[index++] = x++;
				i++;
			}
			
			while(index<=n && i<S.length() && S.charAt(i) == 'D') {
				res[index++] = y--;
				i++;
			}
		}
		res[n] = x;
		return res;
	}
}
