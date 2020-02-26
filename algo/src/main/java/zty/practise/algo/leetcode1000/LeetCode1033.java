package zty.practise.algo.leetcode1000;

/**
 * 第一反应就是要根据题意要求抽象转化
 * 如code描述
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1033 {

	public int[] numMovesStones(int a, int b, int c) {
		int x = Math.min(a, Math.min(b, c));
		int z = Math.max(a, Math.max(b, c));
		int y = a;
		if(x != b && z != b)
			y = b;
		else if(x != c && z != c)
			y = c;
		
		int[] arr = new int[2];
		arr[0] = (y - x > 1 ? 1 : 0) + (z - y > 1 ? 1 : 0);
		//1 3 6 只需要把6移动到2
		if(y - x == 2 || z - y == 2)
			arr[0] = 1;
		arr[1] = z - x - 2; 
		
		return arr;
    }
}
