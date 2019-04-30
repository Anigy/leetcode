public class P215FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, 0, nums.length - 1, k);
    }

    private static int findKthLargestHelper(int[] nums, int first, int last, int k) {
        if (first == last) {
            return nums[first];
        }
        int len = last - first + 1;
        int judge = nums[last];
        int l = first;
        int r = last - 1;
        while (true) {
            while (nums[l] >= judge && l < r) {
                l++;
            }
            while (nums[r] < judge && l < r) {
                r--;
            }
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            } else {
                if (nums[l] < judge) {
                    int tmp = nums[l];
                    nums[l] = judge;
                    nums[last] = tmp;
                } else{
                    int tmp = nums[l + 1];
                    nums[l + 1] = judge;
                    nums[last] = tmp;
                    l++;
                }
                break;
            }
        }
        if (l + 1 < k) {
            return findKthLargestHelper(nums, l + 1, last, k);
        } else if (l + 1 == k) {
            return judge;
        } else if (l + 1 > k) {
            return findKthLargestHelper(nums, first, l -1, k);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 1;
        int r = findKthLargest(nums, k);
        System.out.println(r);
    }
}
