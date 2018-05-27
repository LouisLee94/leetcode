public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slower = head;
        ListNode faster = head.next;
        while (faster != null && faster.next != null) {
            if (slower == faster) return true;
            slower = slower.next;
            faster = faster.next.next;
        }
        return false;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
