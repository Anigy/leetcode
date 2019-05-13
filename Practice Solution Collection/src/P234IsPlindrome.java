public class P234IsPlindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode pre = head;
        ListNode mid = head.next;
        ListNode tmp = pre.next;
        if (mid == null) return true;
        while (mid != null) {
            mid = mid.next;
            if (mid != null) {
                mid = mid.next;
                if (mid != null) {
                    pre = pre.next;
                    tmp = pre.next;
                } else {
                    tmp = pre.next.next;
                    break;
                }
            } else {
                break;
            }
        }
        mid = tmp;
        pre.next = null;
        pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        while (cur != null) {
            if (cur.val != mid.val) return false;
            cur = cur.next;
            mid = mid.next;
        }
        return true;
    }
}
