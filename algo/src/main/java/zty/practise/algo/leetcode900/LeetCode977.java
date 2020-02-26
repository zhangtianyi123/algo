package zty.practise.algo.leetcode900;

/**
 * 想象出一幅图
 * 
 * 一道V字型的图，有了图之后只需要找到拐点（即负正交替的地方）分别
 * 
 * 按照merge算法的思路分别向两边找就可以了
 * 
 * 思路很像merge
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode977 {

	public int[] sortedSquares(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

}
