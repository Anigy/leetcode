public class P136SingleNumber {
    public int singleNumber(int[] nums) {
        int re = 0;
        for(int n : nums) re = re^n;
        return re;
    }
}
