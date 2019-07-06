/**
 * @Classname P98IsValidBST
 * @Description TODO
 * @Date 2019/6/1 12:45
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P98IsValidBST {
    public static boolean result = true;
    public static TreeNode pre = null;

    public static boolean isValidBST(TreeNode root) {
        dfs(root);
        return result;
    }

    public static void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            dfs(node.left);
        }
        if (pre != null && node.val <= pre.val) {
            result = false;
            return;
        }
        pre = node;
        if (node.right != null) {
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode tn = Util.createTree("-2147483648,null,2147483647");
        boolean re = isValidBST(tn);
        System.out.println(re);
    }
}
