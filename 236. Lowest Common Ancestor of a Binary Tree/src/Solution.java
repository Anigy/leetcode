import java.util.Objects;

public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root) || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return root;
        }
        return Objects.isNull(left) ? right : left;
    }
    public static void main(String args[]) {
        TreeNode tn = Util.createTree("3,5,1,6,2,0,8,null,null,7,4");
        System.out.println(lowestCommonAncestor(tn, tn.left, tn.left.right.right).val);
    }
}
