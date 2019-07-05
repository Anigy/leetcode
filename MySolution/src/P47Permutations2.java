import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
class P47Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            tmp.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, result, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}

