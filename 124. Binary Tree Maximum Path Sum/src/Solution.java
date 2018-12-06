import java.util.Objects;

public class Solution {
    public int maxPathSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        if(Objects.isNull(root)) {
            return 0;
        }
        return calcMax(root, maxSum);
    }

    private int calcMax(TreeNode root, int maxSum) {
        if(Objects.isNull(root.left) && Objects.isNull(root.right)) {
            maxSum = Math.max(root.val, maxSum);
            return maxSum;
        }
        int leftMax = Math.max(0, calcMax(root.left, maxSum));
        int rightMax = Math.max(0, calcMax(root.right, maxSum));
        maxSum = Math.max(Math.max(0,leftMax), Math.max(0, rightMax)) + Math root.val);
    }
}
