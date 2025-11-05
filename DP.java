import java.util.*;

public class DP {
    // fibonacci with dp -> tabulation
    public static int fibTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // climing stairs
    // -> recyrsion
    public static int climbStairs(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairsMemo(int n) { // tc -> O(N)
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        // base case
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) {
            return ways[n];
        }

        ways[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return ways[n];

    }

    public static int climbStairsTab(int n) { // tc -> O(N)
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    // 0-1 Knapsack
    // ---> recursion
    public static int knapSackRec(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) { // valid cond
            // include -> added here val[n-1] for value includation
            int ans1 = val[n - 1] + knapSackRec(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapSackRec(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        }

        else { // not valid
            return knapSackRec(val, wt, W, n - 1);

        }
    }

    public static int knapSackMemo(int val[], int wt[], int W, int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) { // valid cond
            // include -> added here val[n-1] for value includation
            int ans1 = val[n - 1] + knapSackMemo(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapSackMemo(val, wt, W, n - 1);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }

        else { // not valid
            dp[n][W] = knapSackMemo(val, wt, W, n - 1);
            return dp[n][W];

        }
    }

    public static int knapSackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1]; // ith item value
                int w = wt[i - 1]; // ith item weight

                if (w <= j) {// valid
                    // include
                    int incProfit = v + dp[i - 1][j - w];

                    // exclude
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                }

                else { // invalid
                       // exclude
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        print(dp);
        return dp[n][W];
    }

    // print 2d DP array
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    // target sum subset
    public static boolean targetSumSubset(int arr[], int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // i means items && j means target sum
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];

                // include cond. with valid cond. also
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }

                // exclude cond.
                if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    // unbounded knapsack
    public static int unboundedKnapSackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1]; // ith item value
                int w = wt[i - 1]; // ith item weight

                if (w <= j) {// valid
                    // include
                    int incProfit = v + dp[i][j - w];

                    // exclude
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                }

                else { // invalid
                       // exclude
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        print(dp);
        return dp[n][W];
    }

    // coin change
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = coins[i - 1]; // ith item value

                if (coins[i - 1] <= j) {// valid
                    // include
                    int incProfit = dp[i][j - v];

                    // exclude
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = incProfit + excProfit;
                }

                else { // invalid
                       // exclude
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        print(dp);
        return dp[n][sum];
    }

    // rod cutting
    // note :- in this approch and code is same as unbounede knapsack cod elooks
    // different then unbounded knapsack bcz we only changes variables ( remove all
    // variables(like incprofit , excprofit) in this so we don't confuse) on the
    // other hand on that knapsack we use varible to store values but here we do
    // direct
    public static int rodCutting(int length[], int prices[], int rodLen) {
        int n = prices.length;
        int dp[][] = new int[n + 1][rodLen + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < rodLen + 1; j++) {

                if (length[i - 1] <= j) {// valid
                    // include
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                }

                else { // invalid
                       // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        print(dp);
        return dp[n][rodLen];
    }

    // longest common subsequence
    // -> recursion
    public static int lcsRec(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + lcsRec(str1, str2, n - 1, m - 1);
        }

        else {
            int ans1 = lcsRec(str1, str2, n - 1, m);
            int ans2 = lcsRec(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }

    }

    // lcs -> memoization
    public static int lcsMemo(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }

        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcsMemo(str1, str2, n - 1, m - 1) + 1;
        }

        else {
            int ans1 = lcsMemo(str1, str2, n - 1, m);
            int ans2 = lcsMemo(str1, str2, n, m - 1);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    // longest common subseq -> tabulation
    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // longest common substring -> tabulation
    public static int lCSubStringb(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int ans = 0;

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    // longest increasing subsequence
    public static int lis1(int arr[]) {

        int n = arr.length;
        int[] lisArr = new int[n]; // will hold the LIS sequence
        int size = 0; // length of LIS found so far

        for (int i = 0; i < n; i++) {
            int x = arr[i];

            // find position with built-in binary search
            int pos = Arrays.binarySearch(lisArr, 0, size, x);

            if (pos < 0) {
                pos = -(pos + 1); // convert to insertion point
            }

            lisArr[pos] = x;

            if (pos == size) {
                size++;
            }
        }

        return size;
    }

    public static int lis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int k = 0;
        for (int num : set) {
            arr2[k] = num;
            k++;
        }

        Arrays.sort(arr2);

        int n = arr.length;
        int m = arr2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];

    }

    // Edit Distance
    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }

    // String Conversation
    public static int stringConv(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int lcs = dp[n][m];
        return (n - lcs) + (m - lcs);
    }

    // wildcard matching
    public static boolean wildcardMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // initilize steps
        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bootem up filling
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case 1 -> ith == jth char || jth char == ?
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // case 2 ignore or case -> choices
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }

                // case 3 else case
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // catlan number
    public static int catlanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catlanRec(i) * catlanRec(n - i - 1);
        }
        return ans;
    }

    public static int catlanMemo(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catlanMemo(i) * catlanMemo(n - i - 1);
        }
        return dp[n] = ans;
    }

    public static int catlanTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // ci = cj * ci-j-1
            }
        }
        return dp[n];
    }

    // Count Bsts
    public static int countBst(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    // mountain ranges
    public static int mountainRanges(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside; // ci = cj * ci-j-1
            }
        }
        return dp[n];
    }

    // matrix chain multiplication
    public static int matrixChainRec(int arr[], int i, int j) {
        if (i == j)
            return 0; // single matrix cost = 0

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = matrixChainRec(arr, i, k)
                    + matrixChainRec(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, cost);
        }
        return min;
    }

    public static int matrixChainTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // init
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        // gap strategy
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    // minimum partitioning
    public static int minPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {

                if (arr[i - 1] <= j) {// valid
                    // include
                    dp[i][j] = Math.max(arr[i - 1] + dp[i][j - arr[i - 1]], dp[i - 1][j]);
                }

                else { // invalid
                       // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);

    }

    // min jumps
    public static int minJumps(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        // fibonacci with dp -> tabulation
        // int n = 5;
        // // System.out.println(fibTab(n));

        // System.out.println(climbStairsMemo(n));
        // System.out.println(climbStairsTab(n));

        // int val[] = { 15, 14, 10, 45, 30 };
        // int wt[] = { 2, 5, 1, 3, 4 };
        // int W = 7;
        // System.out.println(knapSackRec(val, wt, W, val.length));
        // System.out.println(knapSackMemo(val, wt, W, val.length));
        // System.out.println(knapSackTab(val, wt, W));

        // int arr[] = { 4, 2, 7, 1, 3 };
        // int sum = 10;
        // System.out.println(targetSumSubset(arr, sum));

        // int val[] = { 15, 14, 10, 45, 30 };
        // int wt[] = { 2, 5, 1, 3, 4 };
        // int W = 7;
        // System.out.println(unboundedKnapSackTab(val, wt, W));

        // int coins[] = { 2, 5, 3, 6 };
        // int sum = 10;
        // System.out.println(coinChange(coins, sum));

        // int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        // int rodLen = 8;
        // System.out.println(rodCutting(length, prices, rodLen));

        // String str1 = "abcdge";
        // String str2 = "abedg";
        // System.out.println(lcsRec(str1, str2, str1.length(), str2.length()));
        // System.out.println(lcsMemo(str1, str2, str1.length(), str2.length()));
        // System.out.println(lcsTab(str1, str2));

        // String str1 = "ABCDE";
        // String str2 = "ABGCE";

        // System.out.println(lCSubStringb(str1, str2));

        // int arr[] = { 50, 3, 10, 7, 40, 80 };
        // System.out.println(lis(arr));

        // String str1 = "intention";
        // String str2 = "execution";
        // System.out.println(editDistance(str1, str2));

        // String str1 = "pear";
        // String str2 = "sea";
        // System.out.println(stringConv(str1, str2));

        // String s = "baaabab";
        // String p = "*****ba*****ab";
        // System.out.println(wildcardMatch(s, p));

        // int n = 4;
        // System.out.println(catlanRec(n));
        // System.out.println(catlanMemo(n));
        // System.out.println(catlanTab(n));

        // int n = 4;
        // System.out.println(countBst(n));

        // int n = 4;
        // System.out.println(mountainRanges(n));

        // int arr[] = { 1, 2, 3, 4, 3 };
        // System.out.println(matrixChainRec(arr, 1, arr.length - 1));
        // System.out.println(matrixChainTab(arr));

        // int arr[] = { 1, 6, 11, 5 };
        // System.out.println(minPartition(arr));

        int nums[] = { 2, 3, 1, 1, 4 };
        System.out.println(minJumps(nums));
    }
}
