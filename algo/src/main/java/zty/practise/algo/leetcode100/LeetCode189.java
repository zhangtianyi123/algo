package zty.practise.algo.leetcode100;

/**
 * 当我们旋转数组 k 次， k\%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
 * 
 * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素
 *
 * 转化问题，寻找规律
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode189 {

	public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
