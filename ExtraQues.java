import java.util.*;

public class ExtraQues {

    private static final int MOD = 1000000007;

    public static void coin() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[x + 1];
        dp[0] = 1;

        for (int i = 1; i <= x; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = (dp[i] + dp[i - c]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.next();

        String rev = new StringBuilder(str).reverse().toString();

        int i = 0, j = 0, count = 0;

        while (i < str.length() && j < rev.length()) {
            if (str.charAt(i) == rev.charAt(i)) {
                i++;
                j++;
            } else {
                count++;
                i++;
            }
        }

        count += (rev.length() - j);
        System.out.println(count);
    }
}
