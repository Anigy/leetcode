import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname P90SubsetsWithDup
 * @Description TODO
 * @Date 2019/6/4 23:19
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P90SubsetsWithDup {
    public List<List<Integer>> re = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return re;
    }

    public void backtrack(int[] nums, int index, List<Integer> tmp) {
        re.add(new ArrayList<>(tmp));
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            backtrack(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
