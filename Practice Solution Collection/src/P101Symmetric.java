/**
 * @Classname P101Symmetric
 * @Description TODO
 * @Date 2019/6/1 11:56
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P101Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if(left != null && right != null) {
            if(left.val != right.val) return false;
            return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }
}
