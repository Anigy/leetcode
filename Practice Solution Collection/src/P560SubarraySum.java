import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P560SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int result = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        List<Integer> zero = new ArrayList<>();
        zero.add(0);
        map.put(0, zero);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
            int diff = sum[i] - k;
            List<Integer> tmp = map.getOrDefault(diff, new ArrayList<>());
            result += tmp.size();
            List<Integer> cur = map.getOrDefault(sum[i], new ArrayList<>());
            cur.add(i);
            map.put(sum[i], cur);
        }
        return result;
    }
}
