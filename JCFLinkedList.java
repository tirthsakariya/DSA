import java.util.LinkedList; // JCF

public class JCFLinkedList {
    public static void main(String args[]) {
        // create -> only use objects and class not use primitive datatypes
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);

    }
}
