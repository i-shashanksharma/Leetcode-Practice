import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = null, tail = null;
        ListNode[] nodes = new ListNode[n];
        for(int i = 0; i < n; i++) {
            int val = sc.nextInt();
            nodes[i] = new ListNode(val);
            if(head == null) {
                head = nodes[i];
                tail = nodes[i];
            } else {
                tail.next = nodes[i];
                tail = nodes[i];
            }
        }
        int index = sc.nextInt();
        DeleteNode obj = new DeleteNode();
        if(index >= 0 && index < n - 1) {
            obj.deleteNode(nodes[index]);
        }
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}