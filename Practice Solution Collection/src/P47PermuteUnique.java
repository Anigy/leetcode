import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname P47PermuteUnique
 * @Description TODO
 * @Date 2019/6/5 21:45
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P47PermuteUnique {
    public List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return re;
    }

    public void backtrack(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            re.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
