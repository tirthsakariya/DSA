import java.util.*;

public class StackQuestions {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // push at bottem of a stack
    public static void pushAtBottem(Stack<Integer> s, int data) {

        // base case
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // recursion (work , kaam)
        int top = s.pop();
        pushAtBottem(s, data); // recursion
        s.push(top);
    }

    // reverse string using a stack
    public static String reverseString(String str) {
        // making a stack
        Stack<Character> s = new Stack<>();

        // pushing all string element to stack
        for (int idx = 0; idx < str.length(); idx++) {
            s.push(str.charAt(idx));
        }

        // for storing result make string or string builder
        StringBuilder res = new StringBuilder("");

        // checking that until stack is empty pop the element of stack and store in
        // StringBuilder
        while (!s.isEmpty()) {
            char curr = s.pop();
            res.append(curr);
        }

        // returning res StringBuilder to making string
        return res.toString();
    }

    // reverse stack
    public static void reverseStack(Stack<Integer> s) {
        // base case
        if (s.isEmpty()) {
            return;
        }

        // recursion (work , kaam)
        int top = s.pop();
        reverseStack(s); // recursion
        pushAtBottem(s, top);
    }

    // reverse stack other approch
    public static void reverseStack1(Stack<Integer> s) {
        Stack<Integer> result = new Stack<>();
        while (!s.isEmpty()) {
            result.push(s.pop());
        }

        // Just print in reverse
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }

    // print the stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // stocks span problem
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);

        // alrady counted 0 index
        for (int i = 1; i < stocks.length; i++) {

            int currPrice = stocks[i];

            while (!s.isEmpty() && currPrice > stocks[s.peek()]) { // imp condition
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            }

            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    // next greter element (brute force) --> O(n^2)
    public static void nge(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] > arr[i]) {
                    arr[i] = arr[j];
                    found = true;
                    break;
                }
                if (arr[i] > arr[j]) {
                    arr[i] = -1;
                    found = true;
                    break;
                }
            }
            if (!found) { // or you can direct right this without upper arr[i] > arr[j] cond.block
                arr[i] = -1;
            }
            System.out.print(arr[i] + " ");

        }
    }

    // next greter element (optimal) --> O(n)
    public static void nextGreterElement(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            // while loop
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // if-else
            if (s.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = arr[s.peek()];
            }

            // push into stack
            s.push(i);
        }

        // printing nge
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }
    }

    // valid parentheses --> O(n)
    public static boolean isValidParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // opening condition
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }

            // closing condition
            else {
                if (s.isEmpty()) { // checking that stack is emty or not;
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') // pair forming
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidParentheses1(String s) {
        int count = 0;

        // Traverse through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If an open parenthesis is encountered, increase the count
            if (ch == '(' || ch == '{' || ch == '[') {
                count++;
            }
            // If a closing parenthesis is encountered, decrease the count
            else if (ch == ')' || ch == '}' || ch == ']') {
                count--;
            }
        }

        if (count == 0) {
            return true;
        }

        // If count is zero, parentheses are balanced, otherwise, they are not
        return false;
    }

    // duplicate perentheses
    public static boolean duplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing case
            if (ch == ')') {
                int count = 0;
                while (/* !s.isEmpty() && */s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            }

            else {
                s.push(ch);
            }
        }

        return false;
    }

    // max area in histogram --> O(n)
    public static void maxAreaHistogram(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            // while loop
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // if-else
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }

            // push into stack
            s.push(i);
        }

        // next smaller left
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // while loop
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // if-else
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            // push into stack
            s.push(i);
        }

        // crrent area width = j-i-1 or nsr[i] - nsl[i] -1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("Maximum Area in Histogram is : " + maxArea);
    }

    // palindrom linked list with stack
    public static Boolean palindromLL(Node head) {
        Stack<Integer> s = new Stack<>();

        // pushing element into stack
        Node temp = head;
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (!s.isEmpty() && temp != null) {
            if (s.pop() != temp.data) {
                return false;
            } else {
                temp = temp.next;
            }
        }

        return true;
    }

    // decode string
    public static String decodeString(String str) {
        Stack<Integer> s = new Stack<>();
        Stack<StringBuilder> sBuild = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 0;
        for (char ch : str.toCharArray()) {

            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                num = num * 10 + digit;
            }

            else if (ch == '[') {
                sBuild.push(sb);
                sb = new StringBuilder();
                s.push(num);
                num = 0;
            }

            else if (ch == ']') {
                StringBuilder temp = sb;
                sb = sBuild.pop();
                int count = s.pop();

                while (count > 0) {
                    sb.append(temp);
                    count--;
                }
            }

            else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // pushAtBottem(s, 4);
        // while (!s.isEmpty()) {
        // System.out.println(s.pop());
        // }

        // System.out.println(reverseString("helloworld"));

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // //reverseStack1(s);
        // reverseStack(s);
        // printStack(s);

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for (int i = 0; i < span.length; i++) {
        // System.out.print(span[i] + " ");
        // }

        // int arr[] = { 6, 8, 0, 1, 3 };
        // // nge(arr);
        // nextGreterElement(arr);

        // String str = "({})[]";
        // System.out.println(isValidParentheses(str));
        // System.out.println(isValidParentheses1(str));

        // String str = "(((a+b)+(c+d)))";
        // System.out.println(duplicateParentheses(str));

        // int arr[] = { 2, 1, 5, 6, 2, 3 }; // height of histogram
        // maxAreaHistogram(arr);

        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(2);
        // head.next.next.next = new Node(1);
        // System.out.println(palindromLL(head));

        String str = "3[a+b]5[c+d]";
        System.out.println(decodeString(str));
    }
}
