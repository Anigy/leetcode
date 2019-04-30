import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class P199RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        if(Objects.isNull(root)) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            list.add(((ArrayDeque<TreeNode>) q).peekLast().val);
            int size = q.size();
            for(int i = 0; i< size; i++) {
                TreeNode t = q.peek();
                if(Objects.nonNull(t.left)) q.offer(t.left);
                if(Objects.nonNull(t.right)) q.offer(t.right);
                q.poll();
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        TreeNode tn = Util.createTree("2,#,3,#,4,#,5,#,6");
        TreeNode tn = Util.createTree("1,2,3,4,5,6,7");
        Util.printTree(tn);
        List<Integer> l = rightSideView(tn);
        StringBuffer sb = new StringBuffer();
        for(int i : l) {
            sb.append(i + ", ");
        }
        String s = sb.toString();
        System.out.println("sb: " + sb);
        System.out.println("s: " + s);
    }
}
