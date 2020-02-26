package zty.practise.algo.leetcode1200;

/**
 * 关键在于判断有没有连成线
 * 如果存在有三个横坐标相同
 * 或者三个纵坐标相同
 * 或者00 11 22  02 11 20  三个xy相等
 * 或者三个xy和为2
 * 
 * 是否能找到数学判断规律
 * 
 * 使用空间？
 * 
 * 模拟
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1275 {

	public String tictactoe(int[][] moves) {
        int [][] A = new int[3][3];
        int [][] B = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i%2 == 0){
                A[moves[i][0]][moves[i][1]] = 1;
            }else {
                B[moves[i][0]][moves[i][1]] = 2;
            }
        }
        for (int i = 0; i < 3; i++) {
            if(A[i][0] + A[i][1] + A[i][2] == 3)
                return "A";
        }
        for (int i = 0; i < 3; i++) {
            if(A[0][i] + A[1][i] + A[2][i] == 3)
                return "A";
        }
        if(A[0][0] + A[1][1] + A[2][2] == 3 || A[2][0] + A[1][1] + A[0][2] == 3)
            return "A";
        for (int i = 0; i < 3; i++) {
            if(B[i][0] + B[i][1] + B[i][2] == 6)
                return "B";
        }
        for (int i = 0; i < 3; i++) {
            if(B[0][i] + B[1][i] + B[2][i] == 6)
                return "B";
        }
        if(B[0][0] + B[1][1] + B[2][2] == 6 || B[2][0] + B[1][1] + B[0][2] == 6)
            return "B";
        if (moves.length == 9)
            return "Draw";
        return "Pending";
    }

}
