class DesignBrowserHistory {

    class Node {
        String url;
        Node prev, next;

        Node(String url) {
            this.url = url;
        }
    }

    Node current;

    public DesignBrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }
    
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    public static void main(String[] args) {
        DesignBrowserHistory bh = new DesignBrowserHistory("leetcode.com");

        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");

        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));

        bh.visit("linkedin.com");

        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));
    }
}