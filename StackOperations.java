import java.util.*;

public class StackOperations {

    // stack with Array list
    static class stackAL {

        static ArrayList<Integer> list = new ArrayList<>();

        // is empty function
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push function
        public static void push(int data) {
            list.add(data);
        }

        // pop operation
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek operation
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;
        }

        // print function
        public static void print(ArrayList<Integer> list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    // stack with Linked list

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stackLL {
        static Node head = null;

        // is empty function
        public static boolean isEmpty() {
            return head == null;
        }

        // push function
        public static void push(int data) {
            Node newNode = new Node(data);

            // base case
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // pop function
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek operation
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            return top;
        }

        public static void print() {
            Node temp = head;

            // base case
            // if (head == null) {
            // System.out.println("Linked list is empty !!");
            // }

            // traversing threw LinkedList
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // with the java collection framwork you only need to right below line and
        // remove upper all classes and functions and also remove in main arraylist and
        // it's objects and linked list and it's objects...

        // Stack<Integer> s = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();
        stackAL s = new stackAL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print(s.list);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        stackLL sl = new stackLL();
        sl.push(1);
        sl.push(2);
        sl.push(3);
        sl.print();

        while (!sl.isEmpty()) {
            System.out.println(sl.peek());
            sl.pop();
        }

    }
}
