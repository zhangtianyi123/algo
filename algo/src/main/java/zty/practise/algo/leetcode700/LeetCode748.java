package zty.practise.algo.leetcode700;

/**
 * 
 * 类似于字符串的多串匹配
 * 
 * 因为在意的是有没有出现 以及出现的次数
 * 
 * 所以可以将串转而抽象为为hashmap（因为是纯字母  ascii 数组也可以）
 * 
 * 对于个数和出现可以使用hashmap统计
 * 
 * 至于最早出现和最短，只需要顺序遍历判断，如果后面有更短的更新选择即可
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode748 {

	public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word: words)
            if ((word.length() < ans.length() || ans.length() == 0) &&
                    dominates(count(word.toLowerCase()), target))
                ans = word;
        return ans;
    }

    public boolean dominates(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i)
            if (count1[i] < count2[i])
                return false;
        return true;
    }

    public int[] count(String word) {
        int[] ans = new int[26];
        for (char letter: word.toCharArray()){
            int index = Character.toLowerCase(letter) - 'a';
            if (0 <= index && index < 26)
                ans[index]++;
        }
        return ans;
    }
}
