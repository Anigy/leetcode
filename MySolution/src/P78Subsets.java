import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */
class P78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtack(nums, 0, result, tmp);
        return result;
    }

    private void backtack(int[] nums, int idx, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtack(nums, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

