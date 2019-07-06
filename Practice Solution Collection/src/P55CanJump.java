/**
 * @Classname P55CanJump
 * @Description TODO
 * @Date 2019/6/8 10:38
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P55CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int[] helper = new int[nums.length];
        helper[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(helper[i - 1] == 0) return false;
            helper[i] = Math.max(helper[i - 1] - 1, nums[i]);
        }
        return helper[nums.length - 1] >= 0 ? true : false;
    }
}
