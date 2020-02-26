package zty.practise.algo.leetcode900;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先的每一层完成后都检查
 * 
 * 关键是有多个起点同时开始搜索，用同一个queue
 * 
 * 每搜索一层都有可能已经完成
 * 
 * 广度优先搜索超时
 * 
 * 深度优先搜索巧妙就巧妙在累计数字，数字最大证明烂的最早（反复烂）
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode994 {

	class Orange{
        int x;
        int y;
        public Orange(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int[] posx = new int[]{1, 0, -1, 0};
        int[] posy = new int[]{0, 1, 0, -1};
        int count = 0;
        int len1 = grid.length;
        int len2 = grid[0].length;
        
        Queue<Orange> queue = new LinkedList();
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Orange(i, j));
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for(int i = 0; i < size; i++){
                Orange cur = queue.poll();
                for(int j = 0; j < 4; j++){
                	//周围已经没有新鲜橘子了
                    if(cur.x + posx[j] < 0 || cur.x + posx[j] >= len1 || 
                       cur.y + posy[j] < 0 || cur.y + posy[j] >= len2 ||
                       grid[cur.x + posx[j]][cur.y + posy[j]] != 1){
                        continue;
                    }
                    //周围找到了新鲜橘子
                    flag = true;
                    grid[cur.x + posx[j]][cur.y + posy[j]] = 2;
                    queue.offer(new Orange(cur.x + posx[j], cur.y + posy[j]));
                }
            }
            if(flag){
                count ++;
            }
        }
        boolean done = true;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(grid[i][j] == 1){
                    done = false;
                    return -1;
                }
            }
        }
        return count;
    }

}
