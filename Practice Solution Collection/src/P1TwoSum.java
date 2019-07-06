import java.util.*;

/**
 * @Classname P1TwoSum
 * @Description TODO
 * @Date 2019/6/24 23:47
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] re = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.keySet().contains(nums[i])) {
                re[0] = map.get(nums[i]);
                re[1] = i;
                return re;
            }
            map.put(target - nums[i], i);
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] re = twoSum(nums, 9);
        int[] numbers = {1,2,3,4,5};
        boolean result = false;
        Arrays.sort(numbers);
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                count++;
                continue;
            } else if(i > 0 && numbers[i - 1] == 0) {
                continue;
            } else {
                int diff = numbers[i] - numbers[i - 1] - 1;
                if(diff > count)
                    result = false;
                else {
                    count -= diff;
                    continue;
                }
            }
        }
        result = true;
    }
}
