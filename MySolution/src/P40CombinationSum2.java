import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int target, int idx, List<List<Integer>> result, List<Integer> tmp) {
        if (target <= 0) {
            if (target == 0)
                result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if( i > idx && candidates[i] == candidates[i - 1]) continue;
            tmp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
