import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class P90Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int idx, List<Integer> tmp, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            backtrack(nums, i + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}

