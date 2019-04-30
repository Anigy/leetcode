public class P213Rob {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] includeStart = new int[nums.length][2];
        int[][] excludeStart = new int[nums.length][2];
        includeStart[0][0] = Integer.MIN_VALUE;
        includeStart[0][1] = nums[0];
        excludeStart[0][0] = 0;
        excludeStart[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            includeStart[i][0] = Math.max(includeStart[i - 1][0], includeStart[i - 1][1]);
            includeStart[i][1] = includeStart[i - 1][0] + nums[i];
            excludeStart[i][0] = Math.max(excludeStart[i - 1][0], excludeStart[i - 1][1]);
            excludeStart[i][1] = excludeStart[i - 1][0] + nums[i];
        }
        int result = Math.max(Math.max(includeStart[nums.length - 2][0], includeStart[nums.length - 2][1]),
                Math.max(nums[nums.length - 1] + excludeStart[nums.length - 2][0], excludeStart[nums.length - 2][1]));

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
