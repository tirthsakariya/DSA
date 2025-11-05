public class Palindrome {

    public static boolean palindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            if (str.charAt(i) == str.charAt(n - i - 1)) {
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "moom";
        System.out.println(palindrome(str));
    }
}
