/**
 * @Classname P105BuildTree
 * @Description TODO
 * @Date 2019/6/1 10:39
 * @Created by Anigy
 * @Leetcode https://github.com/
 */
public class P105BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public static TreeNode buildHelper(int[] preorder, int[] inorder, int pointer, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(inorder[l]);
        int val = preorder[pointer];
        TreeNode result = new TreeNode(val);
        int index = -1;
        for (int i = l; i <= r; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        TreeNode left = buildHelper(preorder, inorder, pointer + 1, l, index - 1);
        TreeNode right = buildHelper(preorder, inorder, pointer + 1 + index - l, index + 1, r);
        result.left = left;
        result.right = right;
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3};
        int[] b = {1, 2, 3, 4};
        TreeNode re = buildTree(a, b);
        Util.printTree(re);
    }
}
