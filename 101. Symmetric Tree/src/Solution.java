import java.util.Objects;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(Objects.isNull(root)) {
            return true;
        }
        return checkSame(root.left, root.right);
    }
    private boolean checkSame(TreeNode left, TreeNode right) {
        if(Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        } else if(Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }else  {
            return left.val == right.val && checkSame(left.left, right.right) && checkSame(left.right, right.left);
        }
    }
}
