public class DoublyLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        // step 1 :- create new node
        Node newNode = new Node(data);
        size++;

        // base case (if linked list is empty)
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // connection from both sides to newnode
        newNode.next = head; // link
        head.prev = newNode; // connection for head 's previous part
        head = newNode;
    }

    // add last data -> O(1)
    public void addLast(int data) {

        // step 1 :- create new node
        Node newNode = new Node(data);
        size++;

        // base case (if linked list is empty)
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // connection from both sides to newnode
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void print() {
        Node temp = head;

        // // base case
        // if (head == null) {
        // System.out.println("Linked list is empty !!");
        // }

        // traversing threw LinkedList
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // remove first value -> O(1)
    public int removeFirst() {

        // some base cases
        if (head == null) { // or if(size == 0)
            System.out.println("linked list is empty !!");
            return Integer.MIN_VALUE;
        }

        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // step 1 :- storing value of head that gona to remove...
        int val = head.data;

        // step 2 :- making head as neaxt element of linked list so connection with
        // first element autometically broken and doing prev as null...
        head = head.next;
        head.prev = null;

        size--;
        return val;
    }

    // remove last
    public int removeLast() {

        // some base cases
        if (head == null) { // or if(size == 0)
            System.out.println("linked list is empty !!");
            return Integer.MIN_VALUE;
        }

        else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data; // here first we store data of tail
        tail.prev.next = null; // (imp) then we go to tails 's prev point and theen it's next making null means
                               // tail = null making
        tail = tail.prev; // then assigning tail as a it ' s previous point
        size--; // size less
        return val;
    }

    // reverse a linked list
    public void reverse() { // you can remember this as for reverse you need 3 var and 4 steps in while loop
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.print();
        dll.reverse();
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.removeLast();
        dll.print();
        System.out.println(dll.size);
    }
}
