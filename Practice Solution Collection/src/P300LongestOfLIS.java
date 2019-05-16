public class P300LongestOfLIS {
    public int lengthOfLISDP(int[] nums) {
        if (nums.length < 1) return 0;
        int result = 0;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        for (int n : res) {
            result = Math.max(n, result);
        }
        return result;
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 1) return 0;
        int[] helper = new int[nums.length];
        int idx = 0;
        helper[idx++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > helper[idx - 1]) {
                helper[idx++] = nums[i];
            } else {
                int l = 0;
                int r = idx - 1;
                while (l < r) {
                    int m = (l + r) / 2;
                    if(helper[m] == nums[i]) {
                        l = m;
                        break;
                    }
                    else if(helper[m] > nums[i]) r = m -1;
                    else if(helper[m] < nums[i]) l = m + 1;
                }
                helper[l] = nums[i];
            }
        }
        return idx;
    }

    public static int binarySearch(int[] nums, int n) {
        int l = 0;
        int r = nums.length -1;
        while (l < r) {
            int m = (l + r) / 2;
            if(nums[m] == n) {
                l = m;
                break;
            }
            else if(nums[m] > n) r = m -1;
            else if(nums[m] < n) l = m + 1;
        }
        System.out.println(l);
        return l;
    }

    public static void main(String[] args) {
//        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
//        lengthOfLIS(nums);
        int[] nums = {2,5,6};
        binarySearch(nums, 4);
    }
}
