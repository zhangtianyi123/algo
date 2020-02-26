package zty.practise.algo.leetcode1000;


/**
 * 双指针
 * 一个指针从前向后
 * 一个指针从后向前
 * 如果前指针遇到一个0  后指针往前走一步，代表之后的数字被淘汰了
 * 
 * 直到前后指针相遇结束
 * 之后再用新的双指针
 * 
 * 一个选一个放
 * 
 * 最重要的点是判断最后一个0是不是要重复
 * 可能是被顶到倒数第二位，再重复0
 * 也可能是直接被顶到倒数第一位，就不重复了
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode1089 {
	
	public static void main(String[] args) {
		LeetCode1089 s = new LeetCode1089();
		s.duplicateZeros(new int[] {1,5,2,0,6,8,0,6,0});
	}

	public void duplicateZeros(int[] arr) {
		if(arr.length < 2)
			return;
        int i=0;
        int j=arr.length-1;
        boolean flag = false;
        while(i<j) {
        	if(arr[i] == 0) {
        		j--;
        	}
        	i++;
        }
        if(i == j && arr[i] == 0)
        	flag = true;
        
        i=arr.length-1;
        int first = j;
        while(j>=0 && j<i) {
        	if((flag && j == first && arr[j]==0) || arr[j]!=0) {
        		arr[i] = arr[j];
        		i--;
        		j--;
        	} else if(arr[j] == 0){
        		arr[i--] = 0;
        		arr[i--] = 0;
        		j--;
        	}
        }
        System.out.println(arr);
    }
}
