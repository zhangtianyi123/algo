package zty.practise.algo.leetcode000;

/**
 * 子串查找的实现
 * 
 * 关于子串查找可以直接暴力做
 * 
 * 但是要考虑优化的算法的话就很多了
 * 
 * 哈希 kmp....
 * 
 * BM  Sunday
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode028 {

	public static int strStr(String haystack, String needle) {
        int result = -1;
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        if (needleChar.length == 0) {
            return 0;
        }
        // 遍历源字符串
        for (int i = 0; i < haystackChar.length; i++) {
            if (haystackChar[i] == needleChar[0]) {
                if (i + needleChar.length > haystackChar.length) {
                    break;
                }
                for (int j = 0; j < needleChar.length; j++) {
                    result = i;
                    if (haystackChar[i + j] != needleChar[j]) {
                        result = -1;
                        break;
                    }
                }
                if (result > -1) {
                    return result;
                }
            }
        }
        return result;
    }

}
