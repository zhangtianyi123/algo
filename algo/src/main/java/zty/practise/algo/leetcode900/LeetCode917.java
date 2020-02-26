package zty.practise.algo.leetcode900;

/**
 * 
 * 和原因字母反转一个思路
 * 
 * 双指针 判断交换 即可
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode917 {

	public String reverseOnlyLetters(String S) {
        if(S.length() <= 1)return S;
        //左右指针
        int pL = 0; int pR = S.length() - 1;
        StringBuilder sb = new StringBuilder();
        //移动指针
        while(pL < S.length() && pR >= 0){
            //如果左端不是字符
            if(!isOkchar(S.charAt(pL))){
                sb.append(S.charAt(pL));
                pL++;
                //右端不是字符
            }else if(!isOkchar(S.charAt(pR))){
                pR--;
            }else{
                //都是字符
                sb.append(S.charAt(pR));
                pL++;
                pR--;
            }
        }
        //指针没到头的话
//        sb.append(S.substring(pL,S.length()));
       return sb.toString();
    }
    public boolean isOkchar(char c){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

}
