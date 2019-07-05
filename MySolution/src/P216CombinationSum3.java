import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */
class P216CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int n, int k, int idx, List<List<Integer>> result, List<Integer> tmp) {
        if (n <= 0) {
            if (n == 0 && k == 0) {
                result.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = idx; i < 10; i++) {
            tmp.add(i);
            backtrack(n - i, k - 1, i + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

