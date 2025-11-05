public class BacktrackingPractice {

    // Rate in Maze problem
    public static void ratInMaze(int i, int j, int N, int matrix[][], boolean visited[][], String path) {

        // base case
        if (i < 0 || j < 0 || i >= N || j >= N) {
            return;
        }

        if (matrix[i][j] == 0 || visited[i][j] == true) {
            return;
        }

        if (i == N - 1 && j == N - 1) {
            System.out.println("We reached our destination with path : " + path);
            return;
        }

        // recursion(work)
        visited[i][j] = true;

        // down dir.
        ratInMaze(i + 1, j, N, matrix, visited, path + "D");
        // up dir.
        ratInMaze(i - 1, j, N, matrix, visited, path + "U");
        // right dir.
        ratInMaze(i, j + 1, N, matrix, visited, path + "R");
        // left dir.
        ratInMaze(i, j - 1, N, matrix, visited, path + "L");

        visited[i][j] = false; // you can visit this place for other path
    }

    // Knight Tours
    public static boolean isSafe(int[][] grid, int r, int c, int n, int move) {
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != -1) {
            return false;
        }

        grid[r][c] = move;

        if (move == n * n - 1) {
            return true;
        }

        if (isSafe(grid, r - 2, c + 1, n, move + 1))
            return true;
        if (isSafe(grid, r - 1, c + 2, n, move + 1))
            return true;
        if (isSafe(grid, r + 1, c + 2, n, move + 1))
            return true;
        if (isSafe(grid, r + 2, c + 1, n, move + 1))
            return true;
        if (isSafe(grid, r + 2, c - 1, n, move + 1))
            return true;
        if (isSafe(grid, r + 1, c - 2, n, move + 1))
            return true;
        if (isSafe(grid, r - 1, c - 2, n, move + 1))
            return true;
        if (isSafe(grid, r - 2, c - 1, n, move + 1))
            return true;

        grid[r][c] = -1;
        return false;
    }

    public static void knightTours(int n) {
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }

        isSafe(grid, 0, 0, n, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Keyoad combination
    public static void keypadCombination(String digits, String letters, int idx, String keypad[]) {
        // base case
        if (idx == digits.length()) {
            System.out.print(letters + " ");
            return;
        }

        // recursion(work)
        char digit = digits.charAt(idx);
        for (char letter : keypad[digit - '0'].toCharArray()) {
            keypadCombination(digits, letters + letter, idx + 1, keypad);
        }
    }

    public static void main(String[] args) {
        // rate in maze
        // int matrix[][] = {
        // { 1, 1, 1, 1 },
        // { 0, 1, 0, 1 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 1, 1 }
        // };
        // int N = matrix.length;
        // boolean visited[][] = new boolean[N][N];
        // ratInMaze(0, 0, N, matrix, visited, "");

        // knight Tours
        // int n = 8;
        // knightTours(n);

        // keypad combination
        String digit = "23";
        String keypad[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        keypadCombination(digit, "", 0, keypad);

    }
}
