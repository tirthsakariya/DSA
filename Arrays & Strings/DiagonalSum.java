public class DiagonalSum {

    public static void diagonalSum(int matrix[][]) {
        int sum = 0;

        // normal logic code TC --> 0(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix.length; j++) {
        // if (i == j) {
        // sum += matrix[i][j];
        // } else if (i + j == matrix.length - 1) {
        // sum += matrix[i][j];
        // }
        // }
        // }

        // optimized code TC --> 0(n)
        for (int i = 0; i < matrix.length; i++) {
            // pd
            sum += matrix[i][i];
            // sd
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - i - 1];
            }
        }

        System.out.println("Diagonal sum of Primary & Secondary is : " + sum);
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        diagonalSum(matrix);
    }
}
