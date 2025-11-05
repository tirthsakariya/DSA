public class SearchInSortedMatrix {

    // staircase search algo. in matrix
    public static boolean serachInMatrix(int matrix[][], int key) {
        int row = 0, col = matrix.length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("found key at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void brutforce(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("found key at (" + i + "," + j + ")");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        int key = 33;

        serachInMatrix(matrix, key);
        brutforce(matrix, key);
    }
}
