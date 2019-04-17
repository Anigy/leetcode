public class KthLargestPrimNum {
    public static int KthLargestPrimNum(int[] nums, int k) {
        int[] myNums = new int[10000];
        int len = 0;
        for (int i : nums) {
            if (isPrimNum(i)) {
                myNums[len++] = i;
            }
        }
        return findKthLargestPrimNum(myNums, 0, len - 1, k);
    }

    private static int findKthLargestPrimNum(int[] nums, int s, int e, int k) {
        int judge = nums[e];
        int l = s;
        int r = e;
        while(l < r) {
            while(l < r && nums[l] > judge) {
                l++;
            }
            while(l < r && nums[r] <= judge) {
                r--;
            }
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
        }
        int tmp = nums[e];
        nums[e] = nums[r];
        nums[r] = tmp;
        if(r == k-1) {
            return nums[k - 1];
        } else if(r < k - 1) {
            return findKthLargestPrimNum(nums, r + 1, e, k);
        } else {
            return findKthLargestPrimNum(nums, s, r - 1, k);
        }
    }

    public static boolean isPrimNum(int n) {
        if (n > 3 && n % 6 != 1 && n % 6 != 5) {
            return false;
        } else {
            for(int i = 2; i <= Math.sqrt(n) ; i++) {
                if(n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 11, 13, 18, 17, 4, 8, 23, 29, 31, 37, 36, 48, 41, 43, 47};
        int res = KthLargestPrimNum(nums, 5);
        System.out.println(res);
    }
}
