import java.util.*;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(Objects.isNull(root)) {
            return res;
        }
        int dep = 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            List<Integer> re = new ArrayList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode popOne = linkedList.removeFirst();
                re.add(popOne.val);
                if (Objects.nonNull(popOne.left)) {
                    linkedList.addLast(popOne.left);
                }
                if (Objects.nonNull(popOne.right)) {
                    linkedList.addLast(popOne.right);
                }
            }
            res.add(re);
        }
        return res;
    }


}
