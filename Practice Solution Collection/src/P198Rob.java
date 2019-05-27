public class P198Rob {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] rob = new int[nums.length];
        int[] nonRob = new int[nums.length];
        rob[0] = nums[0];
        nonRob[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            rob[i] = nonRob[i - 1] + nums[i];
            nonRob[i] = Math.max(rob[i - 1], nonRob[i - 1]);
        }
        return Math.max(rob[nums.length - 1], nonRob[nums.length - 1]);
    }
}
