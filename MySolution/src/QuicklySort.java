public class QuicklySort {
    public static void quicklySort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int judge = nums[r];
        while (left < right) {
            while (left < right && nums[left] < judge) {
                left++;
            }
            while (left < right && nums[right] >= judge) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        int tmp = nums[right];
        nums[right] = judge;
        nums[r] = tmp;
        quicklySort(nums, l, right - 1);
        quicklySort(nums, right + 1, r);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2};
        quicklySort(nums, 0, nums.length - 1);
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
