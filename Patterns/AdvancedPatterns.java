public class AdvancedPatterns {

    // hollow rectangle pattern

    public static void hollow_rectangle(int rows, int cols) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // inverted & rotated half-pyramid

    public static void inverted_rotated_half_pyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // inverted half-pyramid with numbers

    public static void inverted_half_pyramid(int n) {
        for (int line = 1; line <= n; line++) {
            for (int num = 1; num <= n - line + 1; num++) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    // Floyd's Triangle pattern

    public static void floyd_triangle(int n) {
        int k = 1;
        for (int line = 1; line <= n; line++) {
            for (int num = 1; num <= line; num++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }

    // 0-1 Triange pattern

    public static void _0_1_triangle(int n) {
        for (int line = 1; line <= n; line++) {
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

    // butterfly pattern

    public static void butterfly(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // stars -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces -> 2*(n-i)
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print(" ");
            }
            // stars -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // satrs -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces -> 2*(n-i)
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print(" ");
            }
            // stars -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // solid - rhombus

    public static void solid_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // hollow rhombus

    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // hollow rectangle -> stars // note :- here we also use hollow rectangle code
            // forr this...
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Dimond pattern

    public static void diamond(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // diamond pattern
        diamond(7);

        // hollow rhombus
        // hollow_rhombus(5);

        // solid rhombus
        // solid_rhombus(5);

        // nutterfly pattern
        // butterfly(4);

        // 0_1 triangle
        // _0_1_triangle(5);

        // Floyd's Triangle pattern
        // floyd_triangle(5);

        // inverted half pyramid
        // inverted_half_pyramid(5);

        // inverted & rotated half-pyramid
        // inverted_rotated_half_pyramid(4);

        // hollow rectangle pattern
        // hollow_rectangle(4, 5);
    }
}