public class P416CanPartition {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        } else {
            sum = sum / 2;
        }
        int[][] bag = new int[nums.length + 1][sum + 1];
        for (int i = 0; i < bag.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 || j == 0) {
                    bag[i][j] = 0;
                } else {
                    bag[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 1; i < bag.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    bag[i][j] = Math.max(bag[i - 1][j], bag[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        if (bag[bag.length][sum] == sum) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
