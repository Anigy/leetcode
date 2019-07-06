public class P114Flatten {
    public static void flatten(TreeNode root) {
        flattenHelper(root);
    }

    public static TreeNode flattenHelper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        TreeNode lnode = flattenHelper(node.left);
        TreeNode rnode = flattenHelper(node.right);
        node.left = null;
        if (lnode != null) {
            node.right = lnode;
            if (rnode != null) {
                TreeNode pointer = node;
                while (pointer.right != null) {
                    pointer = pointer.right;
                }
                pointer.right = rnode;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode tn = Util.createTree("null");
        Util.printTree(tn);
        flatten(tn);
        Util.printTree(tn);
    }
}
