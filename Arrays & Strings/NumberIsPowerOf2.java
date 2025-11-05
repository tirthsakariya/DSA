public class NumberIsPowerOf2 {
    public static boolean powerOf2OrNot(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(powerOf2OrNot(15));
    }
}
