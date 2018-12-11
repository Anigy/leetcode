import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<1) {
            return new ArrayList<>();
        }
        return generater(1, n);
    }

    private List<TreeNode> generater(int left, int right) {
        List<TreeNode> tmp = new ArrayList<>();
        if (left > right) {
            tmp.add(null);
            return tmp;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = generater(left, i - 1);
            List<TreeNode> rightTree = generater(i + 1, right);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode tmpRoot = new TreeNode(i);
                    tmpRoot.left = leftTree.get(j);
                    tmpRoot.right = rightTree.get(k);
                    tmp.add(tmpRoot);
                }
            }
        }
        return tmp;
    }
}
