import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class P128LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int result = 0;
        for (int n : nums) set.add(n);
        for (int i : nums) {
            int tmp = i - 1;
            int count = 1;
            while (set.remove(tmp)) {
                tmp--;
                count++;
            }
            tmp = i + 1;
            while (set.remove(tmp)) {
                tmp++;
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
