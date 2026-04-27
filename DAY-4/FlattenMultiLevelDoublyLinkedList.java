class FlattenMultiLevelDoublyLinkedList {
    static class Node {
        int val;
        Node prev, next, child;

        Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            Node child = curr.child;
            Node tail = child;

            while (tail.next != null) {
                tail = tail.next;
            }

            tail.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = tail;
            }
            curr.next = child;
            child.prev = curr;
            curr.child = null;
            curr = curr.next;
        }
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FlattenMultiLevelDoublyLinkedList sol = new FlattenMultiLevelDoublyLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;

        Node c1 = new Node(7);
        Node c2 = new Node(8);
        Node c3 = new Node(9);

        c1.next = c2; c2.prev = c1;
        c2.next = c3; c3.prev = c2;
        n3.child = c1;

        Node head = sol.flatten(n1);

        printList(head);
    }
}