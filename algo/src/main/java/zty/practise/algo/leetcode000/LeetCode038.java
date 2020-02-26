package zty.practise.algo.leetcode000;

/**
 * 这个应该很难有数学规律一步到位 
 * 
 * 那么动态模拟
 * 
 * 字符串处理
 * 
 * 寻找连续相同的数的个数
 * 
 * 【直接提交 ~ 一次过】
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode038 {
	
	public String countAndSay(int n) {
		if(n == 1)
			return "1";
		
		String pre = "1";
		
		for(int i=1; i<n; i++) {
			StringBuilder cur = new StringBuilder();
			for(int j=0; j<pre.length(); j++) {
				if(j == pre.length()-1 || pre.charAt(j) != pre.charAt(j+1)) {
					cur.append("1").append(pre.charAt(j));
				} else {
					int count = 1;
					while(j < pre.length()-1 && pre.charAt(j) == pre.charAt(j+1)) {
						j++;
						count++;
					}
					cur.append(String.valueOf(count)).append(pre.charAt(j));
				}
			}
			pre = cur.toString();
		}
		
		return pre;
    }
}
