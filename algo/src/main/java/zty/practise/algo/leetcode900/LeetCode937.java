package zty.practise.algo.leetcode900;

import java.util.Arrays;

/**
 * 
 * 按照正常的思路做即可
 * 
 * 可以使用外部容器 动态数组
 * 
 * 1 判断
 * 2 如果是数字直接按照顺序add
 * 3 如果是字母日志，则按照题意要求截取子串后比较
 * 
 * 思路2：
 * 不使用外部空间
 * 
 * 这个题最大的考察点在于排序算法
 * 
 * 排序算法不管通过什么底层算法，但是有一点是需要指定的
 * 比较规则，即如何比较确定两个元素，谁排在前面，谁排在后面
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode937 {

	
	/**
	 * 
	 * 重寫排序算法
	 * 
	 * 自定义排序規則
	 * 
	 * @param logs
	 * @return
	 */
	 public String[] reorderLogFiles(String[] logs) {
	        Arrays.sort(logs, (log1, log2) -> {
	            String[] split1 = log1.split(" ", 2);
	            String[] split2 = log2.split(" ", 2);
	            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
	            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
	            if (!isDigit1 && !isDigit2) {
	                int cmp = split1[1].compareTo(split2[1]);
	                if (cmp != 0) 
	                	return cmp;
	                return split1[0].compareTo(split2[0]);
	            }
	            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
	        });
	        return logs;
	    }

}
