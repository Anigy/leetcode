import java.util.Objects;

public class P572IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(Objects.isNull(s) && Objects.isNull(t)) return true;
        else if(Objects.isNull(s) || Objects.isNull(t)) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(Objects.isNull(s) && Objects.isNull(t)) return true;
        else if(Objects.isNull(s) || Objects.isNull(t)) return false;
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
