import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        inorderTravel(root);
        for (int i = 1; i < res.size(); i++) {
            if(res.get(i-1) >= res.get(i)) {
                return false;
            }
        }
        return true;
    }
    private void inorderTravel(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        } else {
            inorderTravel(root.left);
            res.add(root.val);
            inorderTravel(root.right);
        }
    }
}