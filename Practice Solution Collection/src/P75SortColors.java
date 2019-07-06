/**
 * @Classname P75SortColors
 * @Description TODO
 * @Date 2019/6/7 19:34
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P75SortColors {
    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] == 0) l++;
            while (l < r && r < nums.length && nums[r] == 2) r--;
            if (l == r) return;
            if (nums[l] == 1 && nums[r] == 1) {
                for (int i = l + 1; i <= r; i++) {
                    if(i == r) return;
                    if (nums[i] == 1) continue;
                    else if (nums[i] == 0) {
                        nums[l] = 0;
                        nums[i] = 1;
                        break;
                    } else {
                        nums[i] = nums[r];
                        nums[r] = 2;
                        break;
                    }
                }
            } else if (nums[l] > nums[r]) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,0,0,0,1,1};
        sortColors(nums);
        System.out.println(nums);
    }
}
