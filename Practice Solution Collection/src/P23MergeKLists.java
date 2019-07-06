/**
 * @Classname P23MergeKLists
 * @Description TODO
 * @Date 2019/6/9 23:27
 * @Created by Anigy
 * @Email kingjya@163.com
 * @Leetcode https://github.com/
 */
public class P23MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        else {
            int m = (l + r) / 2;
            ListNode left = merge(lists, l, m);
            ListNode right = merge(lists, m + 1, r);
            if (left == null && right == null) return null;
            else if (left == null || right == null) return left == null ? right : left;
            else {
                ListNode re = new ListNode(0);
                ListNode pointer = re;
                while (left != null && right != null) {
                    if (left.val <= right.val) {
                        pointer.next = left;
                        pointer = pointer.next;
                        left = left.next;
                    } else {
                        pointer.next = right;
                        pointer = pointer.next;
                        right = right.next;
                    }
                }
                if (left == null && right == null) return re.next;
                else {
                    pointer.next = left == null ? right : left;
                    return re.next;
                }
            }
        }
    }
}
