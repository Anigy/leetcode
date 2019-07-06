import java.util.ArrayList;
import java.util.List;

/**
 * @Classname P39CombinationSum
 * @Description TODO
 * @Date 2019/6/5 22:45
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P39CombinationSum {
    List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> combinationSumBacktrack(int[] candidates, int target) {
        backtrack(candidates, target, new ArrayList<>(), 0);
        return re;
    }

    public void backtrack(int[] candidates, int target, List<Integer> list, int index) {
        if (target == 0) {
            re.add(new ArrayList<>(list));
            return;
        } else if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
