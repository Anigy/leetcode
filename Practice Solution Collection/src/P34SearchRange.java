/**
 * @Classname P34SearchRange
 * @Description TODO
 * @Date 2019/6/9 9:25
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P34SearchRange {
    int left = Integer.MAX_VALUE;
    int right = Integer.MIN_VALUE;

    public int[] searchRange(int[] nums, int target) {
        int[] re = {-1, -1};
        search(nums, target, 0, nums.length - 1);
        if(left != Integer.MAX_VALUE) {
            re[0] = left;
            re[1] = right;
        }
        return re;
    }

    public void search(int[] nums, int target, int l, int r) {
        if (l > r) return;
        else if (l == r) {
            if (nums[l] == target) {
                left = Math.min(l, left);
                right = Math.max(l, right);
            }
            return;
        } else {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                left = Math.min(mid, left);
                right = Math.max(mid, right);
            }
            search(nums, target, l, mid - 1);
            search(nums, target, mid + 1, r);
        }
    }
}
