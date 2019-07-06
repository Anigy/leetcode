import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname P15ThreeSum
 * @Description TODO
 * @Date 2019/6/12 21:31
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (l == i) {
                    l++;
                    continue;
                } else if (r == i) {
                    r--;
                    continue;
                } else if (nums[l] + nums[r] == 0 - nums[i]) {
                    List<Integer> tmp = Arrays.asList(nums[l], nums[r], nums[i]);
                    re.add(tmp);
                    l++;
                    r--;
                    while (l < nums.length && nums[l] == nums[l - 1]) l++;
                    while (r > i && nums[r] == nums[r + 1]) r--;
                } else if (nums[l] + nums[r] < 0 - nums[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return re;
    }
}
