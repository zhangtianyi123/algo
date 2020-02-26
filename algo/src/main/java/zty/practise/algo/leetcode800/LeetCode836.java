package zty.practise.algo.leetcode800;


/**
 * 
 * 这是一道平面空间题
 * 
 * 
 * 关键是要找到重叠对应到数学规律
 * 
 * 通过画图的方式 => 一条边在该方向的两边之间并且另一方向边的最小值大于最大值，最大值小于最小值
 * 
 * 举例（正，反）
 * 
 * 有一个遗漏的情况就是完全包裹，可以通过反例来完善
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode836 {
	
	public static void main(String[] args) {
		LeetCode836 s = new LeetCode836();
		System.out.println(s.isRectangleOverlap(new int[]{229,-132,833,333}, new int[] {-244,-577,837,804}));
	}

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    	int yup = rec1[3];
    	int ydown = rec1[1];
    	int xleft = rec1[0];
    	int xright = rec1[2];
    	
    	if((rec2[0] > xleft && rec2[0] < xright) || (rec2[2] > xleft && rec2[2] < xright)) {
    		if(rec2[1] < yup && rec2[3] > ydown) {
    			return true;
    		}
    	}
    	
    	if((rec2[1] > ydown && rec2[1] < yup) || (rec2[3] > ydown && rec2[3] < yup)) {
    		if(rec2[0] < xright && rec2[2] > xleft) {
    			return true;
    		}
    	}
    	
     	if(rec2[3] > yup && rec2[1] < ydown && rec2[0] < xleft && rec2[2] > xright) {
    		return true;
    	}
     	
     	if(rec2[3] < yup && rec2[1] > ydown && rec2[0] > xleft && rec2[2] < xright) {
    		return true;
    	}
    	
    	return false;
    }
}
