/**
 * @Classname P31NextPermutation
 * @Description TODO
 * @Date 2019/6/9 22:36
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P31NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int index = nums.length;
        for (int i = nums.length - 2; i >= -1; i--) {
            if (i == -1) index = 0;
            else if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        index = nums[j];
                        nums[j] = nums[i];
                        nums[i] = index;
                        index = i + 1;
                        break;
                    }
                }
                break;
            }
        }
        int l = index;
        int r = nums.length - 1;
        while (l < r) {
            index = nums[r];
            nums[r] = nums[l];
            nums[l] = index;
            l++;
            r--;
        }
    }
}
