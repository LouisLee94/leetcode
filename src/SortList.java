public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        sort(preHead, null);
        return preHead.next;
    }

    private void sort(ListNode start, ListNode end) {
        if (start.next == end || start.next.next == end) return;
        ListNode smaller = new ListNode(0), bigger = new ListNode(0);
        ListNode sp = smaller, bp = bigger;
        ListNode split = start.next;
        ListNode p = split.next;
        while (p != end) {
            if (p.val > split.val) {
                bp.next = p;
                bp = bp.next;
            } else {
                sp.next = p;
                sp = sp.next;
            }
            p = p.next;
        }
        sp.next = split;
        start.next = smaller.next;
        bp.next = end;
        split.next = bigger.next;
        if (start.next.val == bp.val) return;
        sort(start, split);
        sort(split, end);
     }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static void main(String[] args) {
        ListNode l1,l2,l3,l4,l5;
        l1 = new ListNode(-1);
        l2 = new ListNode(5);
        l3 = new ListNode(3);
        l4 = new ListNode(4);
        l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        new SortList().sortList(l1);

    }
}
