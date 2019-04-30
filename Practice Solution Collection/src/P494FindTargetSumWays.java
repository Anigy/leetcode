import java.util.ArrayList;
import java.util.List;

public class P494FindTargetSumWays {
    public static int findTargetSumWaysBFS(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int result = 0;
        int[] cur = new int[1000000];
        cur[0] = 0;
        int length = 1;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = length;
            for (int j = pointer; j < len; j++) {
                cur[++length - 1] = cur[j] + nums[i];
                cur[++length - 1] = cur[j] - nums[i];
            }
            pointer = len;
            if (i == nums.length - 1) {
                for (int k = pointer; k < length; k++) {
                    if (cur[k] == S) result++;
                }
            }
        }
        return result;
    }

    public static int findTargetSumWaysDP(int[] nums, int S) {
        int sum = 0;
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < S) return 0;
        sum += S;
        if (sum % 2 == 1) return 0;
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }
        return dp[sum];
    }

    public static int findTargetSumWaysDFS(int[] nums, int S) {
        return dfsHelper(nums, S, 0, 0);
    }

    public static int dfsHelper(int[] nums, int S, int index, int sum) {
        if(index == nums.length && sum == S) {
            return 1;
        } else if(index == nums.length) {
            return 0;
        }
        return dfsHelper(nums, S, index + 1, sum + nums[index]) +
                dfsHelper(nums, S, index + 1, sum - nums[index]);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int result = findTargetSumWaysBFS(nums, 3);
        System.out.println(result);
    }
}
