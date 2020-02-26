package zty.practise.algo.leetcode600;

/**
 * 动态问题
 *
 * 是否能采用贪心算法？
 * 
 * 针对每个被1划分开的全0子区间（这些区间之间一定是互不关联的子问题）
 * 1 个 0 ：0个
 * 2 个0： 0个
 * 3 个0： 1个
 * 4 个0： 1个
 * 5个0： 2个
 * 6个0： 2个
 * 7个0： 3个
 * 
 *  (n-1) / 2
 * 
 * 考虑边界情况（一边0）
 * （n）/2
 * 
 * 全0
 * (n+1) / 2 
 * 
 * 结论不仅满足贪心 而且每多2 可以增加1 存在此数学规律 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode605 {
	
	public static void main(String[] args) {
		LeetCode605 s  = new LeetCode605();
		s.canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2);
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean allZero = true;
		int firstOne = -1;
		int lastOne = -1;
		for(int i=0; i<flowerbed.length; i++) {
			if(flowerbed[i] == 1) {
				lastOne = i;
				if(firstOne == -1) {
					firstOne = i;
				}
				allZero = false;
			}
		}
		
		if(allZero) {
			return (flowerbed.length + 1) / 2 >= n;
		}
		
		n -= (firstOne) / 2;
		n -= (flowerbed.length - lastOne - 1) / 2;
		
		int count = 0;
		for(int i=firstOne+1; i<=lastOne; i++) {
			if(flowerbed[i] == 0) {
				count++;
			} else {
				n -= (count-1) / 2;
				count = 0;
			}
		}
		return n <= 0;
    }
	
	/**
	 * 
	 * 贪心算法
	 * 
	 * 如果数组中有一个 0，并且这个 0 的左右两侧都是 0，那么我们就可以在这个位置种花
	 * 
	 * 相比于计数再运算 这种直接贪心的方式更好
	 * 
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

}
