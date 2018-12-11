import java.util.Objects;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }else if(Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
