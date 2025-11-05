public class IntersectionOfLL {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null)
            return null;

        Node p1 = headA;
        Node p2 = headB;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        IntersectionOfLL list = new IntersectionOfLL();

        Node headA, headB;
        headA = new Node(10);
        headB = new Node(3);

        Node newNode = new Node(6);
        headB.next = newNode;

        newNode = new Node(9);
        headB.next.next = newNode;

        newNode = new Node(15);
        headA.next = newNode;
        headB.next.next.next = newNode;

        newNode = new Node(30);
        headA.next.next = newNode;
        headA.next.next.next = null;

        Node intersectionNode = list.getIntersectionNode(headA, headB);

        System.out.println(intersectionNode.data);

    }
}
