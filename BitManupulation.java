public class BitManupulation {

    public static void bitmanupulation() {
        System.out.println("Binary AND : " + (5 & 6));
        System.out.println("Binary OR : " + (5 | 6));
        System.out.println("Binary XOR : " + (5 ^ 6));
        System.out.println("Binary 1's Complement : " + (~5));
        System.out.println("Binary Left Shift : " + (1 << 3)); // formula = a * 2^b
        System.out.println("Binary Right Shift : " + (6 >> 1)); // formula = a / 2^b
    }

    // check if number is odd or even
    public static void oddEven(int n) {
        if ((n & 1) == 0) {
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        if ((n & 1 << i) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        return n | 1 << i;
    }

    public static int clearIthBit(int n, int i) {
        return n & (~(1 << i));
    }

    public static int updateIthBit(int n, int i, int newBit) {
        if (newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
    }

    public static int clearLastIthBits(int n, int i) {
        return n & ((~0) << i);
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        return n & (a | b);
    }

    // check if number is power of 2 or not...
    public static boolean powerOf2OrNot(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    // count set bits in number
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

    // fast exponention
    public static int fastExponention(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a; // check lsb
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void uniqueNumber(int arr[]) {
        int n = arr.length; // n = 6
        int res = 0;

        // Step 1: XOR all elements to get a ^ b
        for (int i = 0; i < n; i++) {
            res ^= arr[i]; // res = res ^ arr[i]
        }

        // Step 2: Find rightmost set bit in res
        int i = 0;
        int val = res;
        while ((val & 1) == 0) {
            i++;
            val = val >> 1;
        }

        // Step 3: Create a mask with only that bit set
        int mask = (1 << i);

        int a = 0;

        // Step 4: XOR all numbers with that bit set to find one unique number
        for (int j = 0; j < n; j++) {
            if ((mask & arr[j]) != 0) {
                a ^= arr[j];
            }
        }
        // dry run
        // j |arr[j]| Binary| arr[j] & mask| Condition True? a = a ^ arr[j]
        // 0 1 0001 0001 Yes 0 ^ 1 = 1
        // 1 2 0010 0000 No -
        // 2 3 0011 0001 Yes 1 ^ 3 = 2
        // 3 2 0010 0000 No -
        // 4 1 0001 0001 Yes 2 ^ 1 = 3
        // 5 4 0100 0000 No -

        // Step 5: Second unique number is b = res ^ a
        int b = res ^ a;

        System.out.println("[" + a + "," + b + "]");
    }

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
        int arr[] = { 1, 2, 3, 2, 1, 4 };
        int a = 7, b = 4;
        // bitmanupulation();
        // oddEven(9684);
        // System.out.println(getIthBit(10, 3));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 2, 1));
        // System.out.println(clearLastIthBits(15, 2));
        // System.out.println(clearRangeOfBits(10, 2, 4));
        // System.out.println(powerOf2OrNot(15));
        // System.out.println(countSetBitInNumber(11));
        // System.out.println(fastExponention(3, 5));
        // uniqueNumber(arr);
        System.out.println(countBitsFlip(a, b));
    }
}
