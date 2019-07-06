/**
 * @Classname P53MaxSubArray
 * @Description TODO
 * @Date 2019/6/8 10:55
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P53MaxSubArray {
    public int maxSubArray(int[] nums) {
        int re = nums[0];
        int store = nums[0];
        for (int i = 1; i < nums.length; i++) {
            store = store > 0 ? store + nums[i] : nums[i];
            re = Math.max(store, re);
        }
        return re;
    }
}
