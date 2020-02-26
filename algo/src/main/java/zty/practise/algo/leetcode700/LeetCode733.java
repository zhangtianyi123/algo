package zty.practise.algo.leetcode700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这道题其实就是找图的连通区域
 * 
 * 本质是一个图的搜索问题
 * 
 *	考虑广度优先搜索 
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode733 {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		Queue<String> queue = new LinkedList<>();
		int[] x = new int[] {1, 0 ,-1, 0};
		int[] y = new int[] {0, 1, 0, -1};
		
		queue.add(sr + ":" + sc);
		int target = image[sr][sc];
		while(!queue.isEmpty())  {
			String node = queue.poll();
			int index = node.indexOf(":");
			int r = Integer.valueOf(node.substring(0, index));
			int c = Integer.valueOf(node.substring(index+1, node.length()));
			image[r][c] = -newColor;
			
			for(int i=0; i<4; i++) {
				int nr = r + x[i];
				int nc = c + y[i];
				if(nr >=0 && nc >=0 && nr<image.length && nc<image[0].length && image[nr][nc] == target) {
					queue.add(nr + ":" + nc);
				}
			}
		}
		
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[0].length; j++) {
				if(image[i][j] < 0)
					image[i][j] = newColor;
			}
		}
		
		return image;
    }
	
	/**
	 *
	 *深度优先搜索
	 * 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

	public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }

}
