package zty.practise.algo.leetcode900;

/**
 * 00 - 23
 * 00 - 59
 * 
 * 比如 2 1 6 9
 * 21的选法不可取
 * 
 * 1269
 * 0012
 * 
 * 这个构造最值的动态集合是受到前后选择的限制的
 * 
 * 搜索？
 * 四叉树
 * 
 * 暴力搜索
 * 
 * 本质问题是搜索
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode949 {

	public String largestTimeFromDigits(int[] A) {
		int res = 0;
		
		for(int i=0; i<4; i++) {
			int a = A[i];
			if(a < 3) {
				for(int j=0; j<4; j++) {
					int hour =  a * 10 + A[j];
					if(i != j && hour < 24) {
						for(int k=0; k<4; k++) {
							if(i != k && j != k && A[k] < 6) {
								int l = 6 -i -j - k;
								int min = A[k] * 10 + A[l];
								if(min < 60) {
									res = Math.max(res, hour * 60 + min);
								}
							}
						}
					}
				}
			}
		}
		
		return res >= 0 ? String.format("%02d:%02d", res / 60, res % 60) : "";
    }
}
