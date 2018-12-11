import java.util.Objects;

public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root) || root == p || root == q) {
            return root;
        }
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val >= min && root.val <= max) {
            return root;
        }else if(root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p,q);
        }
    }
    public static void main(String args[]) {
        TreeNode tn = Util.createTree("6,2,8,0,4,7,9,null,null,3,5");
        System.out.println(lowestCommonAncestor(tn, tn.left, tn.right).val);
    }
}
