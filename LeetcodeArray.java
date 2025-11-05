import java.util.Arrays;

public class LeetcodeArray {

    // majority element
    public static int findMajorityElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            // Count occurrences of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // Check if count is more than n/2
            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1; // No majority element
    }

    // single number // bruteforce approch
    public static int singleNumber(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return nums[i];
            }
        }
        return -1;
    }

    // with xor approch
    public static int singleNumberXOR(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i]; // XOR
        }

        return result;
    }

    // contains Duplicate
    public static boolean conatainsDuplicate(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    // contains duplicate with lower TC O(nlogn)
    public static boolean ContainsDuplicate(int nums[]) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

        // Step 1: Copy elements from nums2 into nums1 starting at index m
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Step 2: Sort the entire nums1 array
        Arrays.sort(nums1);

    }

    public static void sort2dmatrix(int a[][]) {
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0])); // Sort by first column
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i])); // Use Arrays.toString() to print row
        }
    }

    public static void productExceptSelf(int[] nums) {
        int product = 1;

        // Step 1: Calculate total product
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }

        // Step 2: Divide product by each element and print result
        for (int i = 0; i < nums.length; i++) {
            nums[i] = product / nums[i];
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {

        int nums[] = { 1, 2, 3, 4 };
        productExceptSelf(nums);
        // int a[][] = {
        // { 5, 7 },
        // { 1, 3 },
        // { 10, 11 },
        // { 4, 5 },
        // };

        // sort2dmatrix(a);

        // int nums1[] = { 4, 5, 6 };
        // int nums2[] = { 1, 2, 3 };
        // int m = 3, n = 3;
        // mergeSortedArray(nums1, m, nums2, n);

        // System.out.println("Majority Element: " + findMajorityElement(arr));
        // System.out.println("Single number is : " + singleNumber(nums));
        // System.out.println("Single number is : " + singleNumberXOR(nums));

        // System.out.println(conatainsDuplicate(nums));
        // System.out.println(ContainsDuplicate(nums));
    }
}
