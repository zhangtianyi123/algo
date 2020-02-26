package zty.practise.algo.leetcode1000;

/**
 * 平面坐标一共4条线
 * 
 * 落实到坐标数字上
 * 
 * 判断三个点是否共线，可以取两点之间的向量，判断两个向量是否共线
 * 
 * 也可以利用斜率
 * 
 * 两条边的长度和不等于第三边的长度，就是三角形
 * 
 * 【数学】
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1037 {
	
	public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];

        double lineLength1 = lineLength(p1, p2);
        double lineLength2 = lineLength(p1, p3);
        double lineLength3 = lineLength(p2, p3);

        boolean isTrangleCondition1 = lineLength1 + lineLength2 > lineLength3;
        boolean isTrangleCondition2 = Math.abs(lineLength1 - lineLength2) < lineLength3;
        return isTrangleCondition1 && isTrangleCondition2;

    }

    public double lineLength(int[] p1, int[] p2) {
        int a2 = (p1[0] - p2[0]) * (p1[0] - p2[0]);
        int b2 = (p1[1] - p2[1]) * (p1[1] - p2[1]);
        return Math.sqrt(a2 + b2);
    }

}
