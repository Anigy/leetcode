import java.util.Objects;

public class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calcMax(root);
        return maxSum;
    }

    private int calcMax(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int val = root.val;
        int leftMax = calcMax(root.left);
        int rightMax = calcMax(root.right);
        if (leftMax > 0) {
            val += leftMax;
        }
        if(rightMax > 0) {
            val += rightMax;
        }
        maxSum = Math.max(val, maxSum);
        return Math.max(root.val, root.val + Math.max(leftMax, rightMax));
    }
}