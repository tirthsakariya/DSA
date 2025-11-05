public class TilingProblem {

    public static int tilingProblem(int n) {// 2 * n (floor size)

        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // work(kaam)

        // vertical choice
        int verticalTiles = tilingProblem(n - 1);

        // horizonat choice
        int horizontalTiles = tilingProblem(n - 2);

        // totalways
        int totalWays = verticalTiles + horizontalTiles;
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(20));
    }
}