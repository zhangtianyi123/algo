package zty.practise.algo.leetcode400;

public class LeetCode434 {

	/**
	 * 通过i-1与i的结合判断即可确定单词
	 * 
	 * @param s
	 * @return
	 */
	public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }

}
