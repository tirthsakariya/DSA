import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueQuestions {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue using Linked list
    static class Queue1 {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null & tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty !!");
            }

            int front = head.data;

            // single element if it is;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty !!");
                return -1;
            }
            return head.data;
        }
    }

    // Queue using 2 stack
    static class Queue2 {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty !!");
                return -1;
            }

            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty !!");
                return -1;
            }

            return s1.peek();
        }
    }

    // stack using 2 queues
    static class stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // remove
        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack !!");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack !!");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

    }

    // first non-repeting ekements in stram of charecters
    public static void firstNonRepeting(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // adding into queue
            q.add(ch);

            // increasing frequency for that char
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    // interleaves 2 halves of queue for even sizes /
    public static void interleaves2Halves(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    // queue reversal
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // generate binary strings untill Node
    public static ArrayList<String> genBinStringN(int n) {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");
        while (n-- > 0) {
            String s = q.peek();
            ans.add(s);
            q.add(s + "0");
            q.add(s + "1");
            q.remove();
        }
        return ans;
    }

    // reverse the firt k element of queue
    public static void revFirstKthEle(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }

    // connect n ropes with minimum cost
    public static int connectNRopes(int arr[]) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // adding all element of array into queue
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        // we need minimum 2 element for running this while loop
        while (pq.size() >= 2) {
            int p1 = pq.remove(); // poping out smallest element from prio. queue
            int p2 = pq.remove(); // poping out 2nd smallest element from prio. queue

            int p = p1 + p2; // adding both p1 and p2

            pq.add(p); // adding that new got element into prio.queue

            cost = cost + p;
        }

        return cost;
    }

    public static void main(String[] args) {
        // Queue1 q = new Queue1();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // Queue2 q = new Queue2();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // Stack q = new Stack();
        // q.push(1);
        // q.push(2);
        // q.push(3);
        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.pop();
        // }

        // first non-repeting ekements in stram of charecters
        // String str = "aabccxb";
        // firstNonRepeting(str);

        // interleaves 2 halves of queue for even sizes
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // interleaves2Halves(q);
        // while (!q.isEmpty()) {
        // System.out.print(q.remove() + " ");
        // }
        // System.out.println();

        // queue reversal
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // queueReversal(q);
        // while (!q.isEmpty()) {
        // System.out.print(q.remove() + " ");
        // }
        // System.out.println();

        // // generate binary strings untill Node
        // System.out.println(genBinStringN(5));

        // reverse the firt k element of queue
        // Queue<Integer> q = new LinkedList<>();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // q.add(60);
        // q.add(70);
        // q.add(80);
        // q.add(90);
        // q.add(100);

        // int k = 5;

        // revFirstKthEle(q, k);

        // while (!q.isEmpty()) {
        // System.out.print(q.remove() + " ");
        // }
        // System.out.println();
        // }

        // connect n ropes with minimum cost
        int arr[] = { 4, 3, 4, 6 };
        System.out.println(connectNRopes(arr));
    }
}