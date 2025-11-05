public class BinaryStringsProblem {

    public static void binStrings(int n, int lastplace, String str) {

        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        // work(kaam)
        if (lastplace == 0) {
            // sit 0 on chair n
            binStrings(n - 1, 0, str + "0");
            binStrings(n - 1, 1, str + "1");
        } else {
            binStrings(n - 1, 0, str + "0");
        }

        // or for better understaing we always want 0 to next places
        // binStrings(n - 1, 0, str.append("0"));
        // if (lastplace == 0) {
        // // sit 0 on chair n
        // binStrings(n - 1, 0, str.append("0"));
        // }
    }

    public static void main(String[] args) {
        binStrings(3, 0, "");
    }
}
