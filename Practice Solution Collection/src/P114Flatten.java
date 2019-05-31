public class P114Flatten {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    public TreeNode flattenHelper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode lNode = flattenHelper(node.left);
        TreeNode rNode = flattenHelper(node.right);
        node.left = null;
        if (lNode != null) node.right = lNode;
        TreeNode tmp = node;
        while (tmp.right != null) {
            tmp.left = null;
            tmp = tmp.right;
        }
        tmp.right = rNode;
        tmp.left = null;
        return node;
    }

    public  static void main(String[] args) {
        TreeNode tn = Util.createTree("2,#,3,#,4,#,5,#,6");
    }
}
