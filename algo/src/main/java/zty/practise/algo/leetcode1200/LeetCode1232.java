package zty.practise.algo.leetcode1200;

/**
 * 
 * 这个判断比矩形等判断还要更简单
 * 
 * 横坐标全部相同
 * 纵坐标全部相同
 * 斜线（斜率）
 * 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1232 {

	public boolean checkStraightLine(int[][] coordinates) {
		int a = 0;
		int b = 0;
		int c = 0;
		int k = Math.abs(coordinates[1][1] - coordinates[0][1]) != 0 ? Math.abs(coordinates[1][0] - coordinates[0][0]) / Math.abs(coordinates[1][1] - coordinates[0][1]) : 0;
		int n = coordinates.length;
		
		for(int i=1; i<n; i++) {
			if(coordinates[i][0] == coordinates[i-1][0]) {
				a++;
			}
			if(coordinates[i][1] == coordinates[i-1][1]) {
				b++;
			}
			if(Math.abs(coordinates[i][1] - coordinates[i-1][1]) !=0 && Math.abs(coordinates[i][0] - coordinates[i-1][0]) / Math.abs(coordinates[i][1] - coordinates[i-1][1]) == k) {
				c++;
			}
		}
		
		return a == n-1 || b == n-1 || c == n-1;
    }
	
	/**
	 * 为了避免坟墓为0的处理，可以采用数学转化为乘法
	 * 
	 * @param coordinates
	 * @return
	 */
	public boolean checkStraightLine2(int[][] coordinates) {
        int x1 =coordinates[1][0]-coordinates[0][0];
       int y1 =coordinates[1][1]-coordinates[0][1];
       for (int i = 2; i < coordinates.length; i++) {
           int x2 =coordinates[i][0]-coordinates[0][0];
           int y2 =coordinates[i][1]-coordinates[0][1];
           if (x1 * y2 != x2 * y1) {
               return false;
           }
       }
       return true;
   }

}
