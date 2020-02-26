package zty.practise.algo.leetcode700;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列组合
 * 
 * 如果只是返回数据的话 2的字母个数次方就可以了
 * 
 * 返回所有可能的话考虑动态的复用拼接
 * 
 * 使用List<StringBuilder>
 * 
 * [脑海中动态的想象]出这个过程，就类似于21世纪各个城市GDP变化一样的变化过程 
 * 
 * @author zhangtianyi
 */
public class LeetCode784 {
	
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            //如果是字母 * 2 一半增加小写，一般增加大写
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }

}
