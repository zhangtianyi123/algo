package zty.practise.algo.leetcode500;

/**
 * 
 * 类似于排序，但是又可以忽略元素本身 只用比较相对顺序
 * 
 * 考虑采用类似于桶排序的思想
 * 
 * ! 计数排序的关键在于需要确定最大的可能数值 比如年龄150  高考分数750  这里nums数组里面数字的最大值
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode506 {

	public static void main(String[] args) {
		LeetCode506 s = new LeetCode506();
		s.findRelativeRanks(new int[]{5, 4, 3, 2, 1});
	}
	
	public String[] findRelativeRanks(int[] nums) {
        String[] bucket = new String[10001];
        String[] res = new String[nums.length];
        
        for(int i=0; i<nums.length; i++) {
        	if(bucket[nums[i]] == null) {
        		bucket[nums[i]] = "" + i;
        	} else {
        		bucket[nums[i]] += "-" + i;
        	}
        }
        
        int num = 1;
        for(int i=10000; i>=0; i--) {
        	if(bucket[i] != null) {
        		String cs = bucket[i];
        		boolean flag = true;
        		while(flag) {
        			int index = 0;
        			if(cs.indexOf("-") != -1) {
        				index = Integer.parseInt(cs.substring(0, cs.indexOf("-")));
        			} else {
        				index = Integer.parseInt(cs);
        				flag = false;
        			}
        			
        			cs = cs.substring(cs.indexOf("-") + 1, cs.length());
        			if(num == 1) {
        				res[index] = "Gold Medal";
        			} else if(num == 2) {
        				res[index] = "Silver Medal";
        			} else if(num == 3) {
        				res[index] = "Bronze Medal";
        			} else {
        				res[index] = "" + num;
        			}
        		}
        		num++;
        	}
        }
        
        
        return res;
    }
}
