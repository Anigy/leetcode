import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname P78Subsets
 * @Description TODO
 * @Date 2019/6/3 23:01
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P78Subsets {
    public static List<List<Integer>> subsetsMINE(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> re = new ArrayList<>();
            for (List<Integer> l : result) {
                List<Integer> combine = new ArrayList<>(l);
                combine.add(nums[i]);
                re.add(combine);
            }
            result.addAll(re);
        }
        return result;
    }

    public static List<List<Integer>> re = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return re;
    }
    public static void backtrack(int[] nums, int index, List<Integer> tmp) {
        re.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> r = subsets(nums);
    }
}
