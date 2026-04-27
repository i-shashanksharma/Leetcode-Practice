class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode prevHead = new ListNode(0);
        ListNode prev = prevHead;
        ListNode currHead = new ListNode(0);
        ListNode curr = currHead;

        while (head != null) {
            if (head.val < x) {
                prev.next = head;
                prev = prev.next;
            } else {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        
        curr.next = null;
        prev.next = currHead.next;
        return prevHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        PartitionList sol = new PartitionList();
        ListNode result = sol.partition(head, 3);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
