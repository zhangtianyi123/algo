package zty.practise.algo.leetcode400;

/**
 * 搜索题
 * 
 * 两个变量
 * 
 * 限定条件（两个变量之间的关系）
 * 
 * a * b的结果存在交换 sqrt(area)
 * 
 * < sqrt 的密度更大 搜索效率高于 搜索 > sqrt的区间
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode492 {

	public int[] constructRectangle(int area) {
		int p = (int)Math.sqrt(area);
		if(p * p == area)
			return new int[] {p, p};
		
		int R = p;
		while(R > 0) {
			if(area % R == 0)
				return new int[] {area / R, R};
			R--;
		} 
		
		return new int[]{};
    }
}
