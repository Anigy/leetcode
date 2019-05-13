public class P238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return new int[0];
        int[] result = new int[nums.length];
        result[0] = 1;
        if (nums.length == 1) return result;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] = tmp * result[j];
            tmp *= nums[j];
        }
        return result;
    }
}
