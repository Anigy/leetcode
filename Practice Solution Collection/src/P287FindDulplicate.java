public class P287FindDulplicate {
    public int findDuplicate(int[] nums) {
        int ps = 0;
        int pf = 0;
        do {
            ps = nums[ps];
            pf = nums[nums[pf]];
        } while (ps != pf);
        pf = 0;
        while (ps != pf) {
            ps = nums[ps];
            pf = nums[pf];
        }
        return ps;
    }

    public static int findDuplicateBS(int[] nums) {
        int l = 1;
        int r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] <= m) count++;
            }
            if(count <= m) l = m + 1;
            else if(count > m) r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        findDuplicateBS(nums);
    }
}
