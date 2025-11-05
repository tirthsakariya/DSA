public class UniqueNumberII {
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

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2, 1, 4 };
        uniqueNumber(arr);
    }
}
