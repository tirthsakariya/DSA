import java.util.*;

public class _2DArrayBasics {

    public static void search(int matrix[][], int key) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (largest < matrix[i][j]) {
                    largest = matrix[i][j];
                }
                if (smallest > matrix[i][j]) {
                    smallest = matrix[i][j];
                }
                if (matrix[i][j] == key) {
                    System.out.println("found at cell = (" + i + "," + j + ")");
                    break;
                }

            }
        }
        System.out.println("Largest num is = " + largest);
        System.out.println("Smallest num is = " + smallest);

    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];

        Scanner s = new Scanner(System.in);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix, 70);
    }
}
