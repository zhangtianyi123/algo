package zty.practise.algo.leetcode1000;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 动态模拟
 * 
 * 但是需要查询连接关系
 * 
 * 广度优先搜索？
 * 
 * 限制每个节点的度为3，同时提供四种颜色，因此不需要回溯
 * 只需要一路放就可以了 当然孤立点（0度点放1即可）
 * 
 * 关键是信息的存储和搜索！！！
 * 对于每个节点 查看相邻点的颜色【信息】  染上不同的即可
 * 
 * 临界点信息存储（为了快速查询）
 * Map<Set>
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1042 {

	public int[] gardenNoAdj(int N, int[][] paths) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        /**
         * 顺序遍历节点，放入颜色，只需要和现有相邻已经放入的不冲突就可以了
         * 因为虽然有相邻限制，但是这里是不需要回溯的
         * 一定存在解
         * 因为限制了度<=3
         */
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
