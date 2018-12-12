import java.util.Objects;
import java.util.Stack;

public class Solution {
    public void reorderList(ListNode head) {
        if (Objects.isNull(head)) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        Stack<ListNode> right = new Stack<>();
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = slow;
        slow = slow.next;
        while (Objects.nonNull(slow)) {
            right.push(slow);
            slow = slow.next;
        }
        ListNode travel = head;
        while (right.size() > 0) {
            ListNode popOne = right.pop();
            ListNode tmp = travel.next;
            travel.next = popOne;
            popOne.next = tmp;
            if(Objects.nonNull(tmp)) {
                travel = tmp;
            }else{
                travel = popOne;
            }
        }
        travel.next = half;
        half.next = null;
        return;
    }
}
