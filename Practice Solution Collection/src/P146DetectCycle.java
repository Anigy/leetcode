public class P146DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            } else return null;
            if(fast == null) return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
