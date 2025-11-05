public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Methods

    // add first data -> O(1)
    public void addFirst(int data) {

        // step 1 :- create new node
        Node newNode = new Node(data);
        size++;

        // base case (if linked list is empty)
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 :- newNode next = head (connection into linked list)
        newNode.next = head; // link

        // step 3 :-head = newNode (assigning newnode to head bcz we want to add data
        // first)
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

        // step 2:- tail -> next = newnode (linking newnode with tail 's next)
        tail.next = newNode;

        // step 3 :- tail = newNode (assigning newnode to tail bcz we want to add data
        // last)
        tail = newNode;
    }

    // print the Linked list -> O(n)
    public void print() {
        Node temp = head;

        // // base case
        // if (head == null) {
        // System.out.println("Linked list is empty !!");
        // }

        // traversing threw LinkedList
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // add data in middle
    public void addMiddle(int idx, int data) {

        // base case
        if (idx == 0) {
            addFirst(data);
            return;
        }

        // step 1 :- create new node
        Node newNode = new Node(data);
        size++;

        // step 2 :- traversing threw LinkedList
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // step 3 :- when i = idx-1 & temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
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
        // first element autometically broken...
        head = head.next;

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

        // step 1 :- prev : i = size -2 ( to reach the previous in ll);
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        // step 2 :- deleting the value of prev.next means last element means tail
        int val = prev.next.data; // val = tail.data // you can use tail also
        prev.next = null; // here we do tail = null also right tail = null;

        // step 3 :- making tail as a prev node and doing size - 1
        tail = prev;
        size--;
        return val;

    }

    // iterative search 0(n)
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found
        return -1;
    }

    // recursive search O(n)
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    // reverse a linked list
    public void reverse() { // you can remember this as for reverse you need 3 var and 4 steps in while loop
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // find and remove nth node from end
    public void removeNthfromEnd(int n) {
        // calculateing size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // base case
        if (n == size) {
            head = head.next; // remove 1st operation
            return;
        }

        // size -n
        Node prev = head;
        for (int i = 1; i < size - n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // check if linked list is palindrom or not ?

    // slow - fast approch to find mid element
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        // slow = mid;
        return slow;
    }

    public boolean llPalindrome() {
        // base case
        if (head == null || head.next == null) {
            return true;
        }

        // step 1 :- find mid
        Node midNode = findMid(head);

        // step 2 :- reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        // step 3 :- compare left half and right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // detect cycle / loop that exist in linked list ?
    public static boolean detectCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                return true; // cycle exists
            }
        }
        return false;
    }

    // remove cycle / loop that exist in linked list ?
    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;

        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2

            if (slow == fast) {
                cycle = true; // cycle exists
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast; // storing last node
            slow = slow.next; // +1
            fast = fast.next; // +1
        }

        // remove cycle -> last.next = null
        prev.next = null; // imp line bcz lastnode.next = null so break loop/cycle
    }

    // merge sort in linked list O(nlogn)

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // here slow is mid
    }

    public Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }

            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left & right part to call mergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    // zig - zag linked list
    public void zigZag() {

        // find mid
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        Node mid = slow; // here slow is mid

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;
        Node nextL, nextR;

        // alternate merging
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    // delete n nodes after m nodes on linked list
    public Node deleteNAfterM(Node head, int m, int n) {
        Node temp = head;

        while (temp != null) {
            // Skip m-1 nodes
            for (int i = 1; i < m && temp != null; i++) {
                temp = temp.next;
            }

            // If we've reached end or no more nodes to delete
            if (temp == null || temp.next == null)
                break;

            // Start deletion from next node
            Node del = temp.next;
            for (int i = 0; i < n && del != null; i++) {
                del = del.next;
            }

            // Link current node to the node after n deletions
            temp.next = del;

            // Move temp to next segment
            temp = del;
        }

        return head;

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.print();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.print();
        // ll.addMiddle(2, 3);
        // ll.print();
        // ll.removeNthfromEnd(3);
        // ll.print();
        // ll.reverse();
        // ll.print();
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.iterativeSearch(4));
        // System.out.println(ll.recursiveSearch(4));
        // System.out.println(ll.size);

        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(5);
        // ll.addLast(4);
        // ll.print();
        // System.out.println(ll.llPalindrome());

        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head.next;
        // // 1->2->3->h
        // System.out.println(detectCycle());
        // removeCycle();
        // System.out.println(detectCycle());

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZag();
        ll.print();
        ll.deleteNAfterM(head, 2, 2);
        ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();
    }
}
