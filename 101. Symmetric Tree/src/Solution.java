import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(Objects.isNull(root)) {
            return true;
        }
        return checkSame(root.left, root.right);
    }
    private boolean checkSame(TreeNode left, TreeNode right) {
        if(Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        } else if(Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }else  {
            return left.val == right.val && checkSame(left.left, right.right) && checkSame(left.right, right.left);
        }
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        TreeNode iter = root;
        List<TreeNode> queuen = new ArrayList<>();
        List<TreeNode> tempQueuen = new ArrayList<>();
        queuen.add(root);
        while (queuen.size() > 0) {
            boolean flag = false;
            tempQueuen.clear();
            for (TreeNode node : queuen) {
                if (Objects.isNull(node)) {
                    tempQueuen.add(null);
                    tempQueuen.add(null);
                } else {
                    flag = true;
                    tempQueuen.add(node.left);
                    tempQueuen.add(node.right);
                }
            }
            if(!flag) {
                return true;
            }else if (!isValidatedQ(tempQueuen)) {
                return false;
            }
            queuen.clear();
            queuen.addAll(tempQueuen);
        }
        return false;
    }

    private static boolean isValidatedQ(List<TreeNode> queuen) {
        if (queuen.size() == 0) {
            return true;
        } else if (queuen.size() % 2 != 0) {
            return false;
        }
        int l = 0;
        int r = queuen.size() - 1;
        while (l < r) {
            if ((Objects.isNull(queuen.get(l)) && Objects.nonNull(queuen.get(r)))
                    || (Objects.nonNull(queuen.get(l)) && Objects.isNull(queuen.get(r)))
                    || (Objects.nonNull(queuen.get(l))
                    && Objects.nonNull(queuen.get(r))
                    && queuen.get(l).val != queuen.get(r).val)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
