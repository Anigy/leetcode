import java.util.Objects;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return false;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            if (sum == root.val) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
