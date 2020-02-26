package zty.practise.algo.leetcode1000;

/**
 * 脑海中柱状图模拟过程
 * 
 * 动态性太强 难以找到直接的规律
 * 
 * 考虑模拟 使用桶计数
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1046 {

	/**
	 * 最大和次大之差，不可能比最大还大，但可能比次大更大
	 * 
	 * 有时候在循环内再次起循环比同一个循环通过不同的标记+条件判断更清晰
	 * 
	 * @param stones
	 * @return
	 */
	public int lastStoneWeight(int[] stones) {
		int[] bucket = new int[1001];
		for (int i : stones) {
			bucket[i]++;
		}

		int i = 1000;
		for (; i >= 0; i--) {
			//最大值
			bucket[i] %= 2;
			if (bucket[i] == 0) {
				continue;
			} else {
				int next = i - 1;
				//找次小的，如果找不到，说明i就是最终结果了
				while (next >= 0 && bucket[next] == 0) {
					next--;
				}
				if (next < 0)
					break;
				else {
					//不管是次大值还是最大值减去次大值的新值，都一定比最大值小
					bucket[i - next]++;
					bucket[next]--;
				}
			}
		}

		return i < 0 ? 0 : i;
	}
}
