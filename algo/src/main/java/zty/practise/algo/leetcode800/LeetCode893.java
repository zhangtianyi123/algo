package zty.practise.algo.leetcode800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解题分为两步
 * 
 * 第一步就是确定相等
 * 
 * 第二步就转化为将“相同”的字符串分到一组
 * 其实最好的是使用空间工具比如map
 * 是否能转化出每个的一种基本格式
 * 自定义hash?
 * 
 * 
 * 因为26的10次方在long类型范围以内
 * 所以可以将字符串转为无冲突的hash值
 * 
 * 所以关键就是实现比较两个字符串奇数偶数位字母相同的方法
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode893 {
	
	public static void main(String[] args) {
		LeetCode893 s = new LeetCode893();
		s.numSpecialEquivGroups(new String[] {"aa","bb","ab","ba"});
	}
	
	/**
	 * 相较于排序，更接近问题的本质，这里相当于桶计数
	 * 只需要得到各个字母的数量 而非一个顺序 即可判断相等
	 * 
	 * @param A
	 * @return
	 */
	public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }

	public int numSpecialEquivGroups3(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) {
            char[] chars = str.toCharArray();
            String odd = "", even = "";
            for (int i = 0; i < chars.length; i++) {
                //如果是奇数位
                if ((i & 1) == 1) {
                    odd += str.charAt(i);
                } else {
                    //如果为偶数位
                    even += str.charAt(i);
                }
            }
            //排序后拼接
            char[] oddArr = odd.toCharArray();
            Arrays.sort(oddArr);
            char[] evenArr = even.toCharArray();
            Arrays.sort(evenArr);
            set.add(new String(oddArr) + new String(evenArr));
        }

        return set.size();
    }

	public int numSpecialEquivGroups2(String[] A) {
		Set<String> set = new HashSet<>();
		for(String a : A) {
			set.add(parseToInt(a));
		}
		
		return set.size();
    }
	
	private String parseToInt(String str) {
		long a = 0;
		long b = 0;
		List<Integer> lista = new ArrayList<>();
		List<Integer> listb = new ArrayList<>();
		
		for(int i=0; i<str.length(); i++) {
			int n = str.charAt(i) - 'a';
			if(i % 2 == 0) {
				lista.add(n);
			} else {
				listb.add(n);
			}
		}
		Collections.sort(lista);
		Collections.sort(listb);
		for(int e : lista) {
			a = a * 26 + e;
		}
		
		for(int e : listb) {
			b = b * 26 + e;
		}
		
		return a + "" + b;
	}
}
