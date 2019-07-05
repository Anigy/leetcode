import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */
class P46Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, visited, result, new ArrayList<>());
        return result;
    }

    public void backTrack(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> tmp) {
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            tmp.add(nums[i]);
            visited[i] = true;
            backTrack(nums, visited, result, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}

