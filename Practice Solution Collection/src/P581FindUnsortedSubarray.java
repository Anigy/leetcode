public class P581FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int startIndex = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                if (startIndex == Integer.MIN_VALUE) {
                    startIndex = i - 1;
                }
                min = Math.min(min, nums[i]);
                endIndex = i;
            }
        }
        for (int i = 0; i < startIndex; i++) {
            if (nums[i] > min) {
                startIndex = i;
                break;
            }
        }
        return startIndex == Integer.MIN_VALUE ? 0 : endIndex - startIndex + 1;
    }
}
