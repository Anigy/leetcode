import java.util.ArrayList;
import java.util.List;

public class P39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int idx, int target, List<List<Integer>> result, List<Integer> tmp) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            target -= nums[i];
            tmp.add(nums[i]);
            backtrack(nums, i, target, result, tmp);
            target += nums[i];
            tmp.remove(tmp.size() - 1);
        }
    }
}
