import java.util.ArrayList;
import java.util.List;

/**
 * @Classname P46Permute
 * @Description TODO
 * @Date 2019/6/5 21:31
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P46Permute {
    public List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return re;
    }

    public void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            re.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtrack(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
