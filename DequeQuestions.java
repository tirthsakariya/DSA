import java.util.*;
import java.util.LinkedList;

public class DequeQuestions {

    static class stack {
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            return dq.removeLast();
        }

        public int peek() {
            return dq.getLast();
        }

    }

    static class queue {
        Deque<Integer> dq1 = new LinkedList<>();

        public void push(int data) {
            dq1.addLast(data);
        }

        public int pop() {
            return dq1.removeFirst();
        }

        public int peek() {
            return dq1.getFirst();
        }

    }

    public static void main(String[] args) {
        // deque using JCF

        // Deque<Integer> dq = new LinkedList<>();
        // dq.addFirst(1);
        // dq.addFirst(2);
        // dq.addLast(3);
        // dq.addLast(4);
        // System.out.println(dq);
        // dq.removeLast();
        // System.out.println(dq);
        // System.out.println(dq.getFirst());
        // System.out.println(dq.getLast());

        // stack using deque
        // stack s = new stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        // queue using deque
        queue q = new queue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}
