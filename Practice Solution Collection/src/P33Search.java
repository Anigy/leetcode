/**
 * @Classname P33Search
 * @Description TODO
 * @Date 2019/6/9 11:18
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P33Search {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int l, int r) {
        if (l > r || l == r && nums[l] != target) return -1;
        int mid = (l + r) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] >= nums[l]) {
            if (nums[l] > target || nums[mid] < target) {
                return search(nums, target, mid + 1, r);
            } else return search(nums, target, l, mid - 1);
        } else {
            if (nums[r] < target || nums[mid] > target) return search(nums, target, l, mid - 1);
            else return search(nums, target, mid + 1, r);
        }
    }
}
