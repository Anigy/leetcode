import java.util.ArrayList;
import java.util.List;

public class P448FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int swap = nums[current - 1];
            while (current - 1 != i && current != swap) {
                nums[current - 1] = current;
                nums[i] = swap;
                current = swap;
                swap = nums[current - 1];
            }
        }
        for (int j = 1; j <= nums.length; j++) {
            if (j != nums[j - 1]) {
                result.add(j);
            }
        }
        return result;
    }
}
