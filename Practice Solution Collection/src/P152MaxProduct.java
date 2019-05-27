public class P152MaxProduct {
    public static int maxProduct(int[] nums) {
        if (nums.length < 1) return 0;
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]), nums[i]);
            max[i] = Math.max(Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]), nums[i]);
            result = Math.max(min[i], max[i]) > result ? Math.max(min[i], max[i]) : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, 7};
        int result = maxProduct(nums);
        System.out.println(result);
        return;
    }
}
