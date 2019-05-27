public class P169MajorElement {
    public int majorityElement(int[] nums) {
        int target = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
                count++;
            } else {
                if (target == nums[i])
                    count++;
                else
                    count--;
            }
        }
        return target;
    }
}
