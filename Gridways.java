public class Gridways {

    public static int gridWays(int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == n) {
            return 0; // (boundry cross cond.) most imp. corner case bcz if you go down and down or
                      // right and right it goes out of grid so that 's why this corner case needed...
        }

        // recursion (work , kaam)

        // down choice
        int w1 = gridWays(i + 1, j, n, m);

        // right choice
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println("Total Grid Ways is : " + gridWays(0, 0, n, m));
    }
}
