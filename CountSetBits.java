public class CountSetBits {
    public static int countSetBitInNumber(int n) {
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
        System.out.println(countSetBitInNumber(11));
    }
}
