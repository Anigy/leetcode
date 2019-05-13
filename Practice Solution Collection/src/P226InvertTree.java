public class P226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode result = new TreeNode(root.val);
        if(root.left != null) result.right = invertTree(root.left);
        if(root.right != null) result.left = invertTree(root.right);
        return result;
    }
}
