public class CountBitsFilp {
    public static int countBitsFlip(int a, int b) {
        int n = a ^ b;
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++; // checking lsb
            }
            n = n >> 1;
        }
        return count;

    }

    public static void main(String[] args) {
        int a = 7, b = 4;
        System.out.println(countBitsFlip(a, b));
    }
}
