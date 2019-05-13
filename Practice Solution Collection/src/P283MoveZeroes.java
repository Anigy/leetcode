public class P283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while(r < nums.length) {
            while(l < nums.length && nums[l] != 0) l++;
            r = Math.max(l + 1, r);
            while(r < nums.length && nums[r] == 0) r++;
            if(r < nums.length) {
                nums[l] = nums[r];
                nums[r] = 0;
                r++;
            }
        }
    }
}
