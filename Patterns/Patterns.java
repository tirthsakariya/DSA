public class Patterns {
    public static void main(String[] args) {

        // Star pattern
        // for (int i = 1; i <= 5; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.err.print("*");
        // }
        // System.out.println();
        // }

        // Inverte-star pattern
        // for (int line = 1; line <= 4; line++) {
        // for (int star = 1; star <= 4 - line + 1; star++) {
        // System.err.print("*");
        // }
        // System.out.println();
        // }

        // Half-Pyramid Pattern
        // int size = 4;
        // for (int line = 1; line <= size; line++) {
        // for (int num = 1; num <= line; num++) {
        // System.err.print(num);
        // }
        // System.out.println();
        // }

        // Character pattern
        // int size = 4;
        // char ch = 'A';
        // for (int line = 1; line <= size; line++) {
        // for (int chars = 1; chars <= line; chars++) {
        // System.err.print(ch);
        // ch++;
        // }
        // System.out.println();
        // }

        // Inverted Half-Pyramid with number pattern
        // int size = 5;
        // for (int line = 1; line <= size; line++) {
        // for (int num = 1; num <= size - line + 1; num++) {
        // System.out.print(num);
        // }
        // System.out.println();
        // }

        // Floyd's Triangle pattern
        // int size = 5;
        // int n = 1;
        // for (int line = 1; line <= size; line++) {
        // for (int num = 1; num <= line; num++) {
        // System.out.print(n);
        // n++;
        // }
        // System.out.println();
        // }

        // 0-1 Triange pattern

        int size = 5;

        for (int line = 1; line <= size; line++) {
            for (int num = 1; num <= line; num++) {
                if ((line + num) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}