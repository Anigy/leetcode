import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname P40CombinationSum2
 * @Description TODO
 * @Date 2019/6/6 7:37
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P40CombinationSum2 {
    List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return re;
    }

    public void backtrack(int[] candidates, int remind, List<Integer> list, int index) {
        if (remind == 0) {
            re.add(new ArrayList<>(list));
            return;
        } else if (remind < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backtrack(candidates, remind - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
