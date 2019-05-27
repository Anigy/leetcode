public class P215FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
//        return findKthLargestHelper(nums, 0, nums.length - 1, k);
        return findHelper(0, nums.length - 1, nums, k);
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

    public static int findHelper(int first, int last, int[] nums, int k) {
        int l = first;
        int r = last;
        if (l == r)
            return nums[l];
        int judge = l;
        int tmp;
        while (l < r) {
            while (l < r && nums[r] < nums[judge])
                r--;
            while (l < r && nums[l] >= nums[judge])
                l++;
            tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
        }
        tmp = nums[l];
        nums[l] = nums[judge];
        nums[judge] = tmp;
        if (k == l + 1)
            return nums[k - 1];
        else if (k < l + 1)
            return findHelper(first, l - 1, nums, k);
        else
            return findHelper(l + 1, last, nums, k);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int k = 2;
        int r = findKthLargest(nums, k);
        System.out.println(r);
    }
}
