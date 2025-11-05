import java.util.*;

public class ArrayBasics {

    // passing array as an arguments
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] += 1;
        }
    }

    // linear search
    public static void linearSearch(int num[], int key) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                System.out.println("key is found at index " + i);
                return;
            }

        }
        System.out.println("key is not found");
    }

    // largest number
    public static void largestnumber(int num[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        // int largest = 0;
        // int smallest = 0;

        for (int i = 0; i < num.length; i++) {
            if (largest < num[i]) {
                largest = num[i];
            }
            if (smallest > num[i]) {
                smallest = num[i];
            }
        }
        System.out.println("Largest value is : " + largest);
        System.out.println("Smallest value is : " + smallest);
    }

    // binary search
    public static int binarysearch(int num[], int key) {
        int start = 0, end = num.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == key) {
                return mid;
            } else if (num[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // reverse an array
    public static void reversearray(int num[]) {
        int first = 0, last = num.length - 1;
        while (first < last) {
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;

            first++;
            last--;
        }
    }

    // pair is an array
    public static void pairarray(int num[]) {
        int tp = 0;
        for (int i = 0; i < num.length; i++) {
            int curr = num[i];
            for (int j = i + 1; j < num.length; j++) {
                int nextcurr = num[j];
                System.out.print("(" + curr + "," + nextcurr + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total pairs is : " + tp);
    }

    // print subarray & max , min sum
    public static void subarray(int num[]) {
        int tp = 0;
        int maxsum = Integer.MIN_VALUE;
        int minsum = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            int start = i;
            int largestsum = Integer.MIN_VALUE;
            int smallestsum = Integer.MAX_VALUE;

            for (int j = i; j < num.length; j++) {
                int end = j;
                int sum = 0;

                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " ");
                    sum = sum + num[k];
                    if (largestsum < sum) {
                        largestsum = sum;
                    }
                    if (smallestsum > sum) {
                        smallestsum = sum;
                    }
                }
                tp++;
                if (maxsum < sum) {
                    maxsum = sum;
                }
                if (minsum > sum) {
                    minsum = sum;
                }
                System.out.println("   (Sum of this subarray is : " + sum + ")");
                System.out.println();

            }
            System.out.println();
            System.out.println("largest sum of subarray is : " + largestsum);
            System.out.println();
            System.out.println("smallest sum of subarray is : " + smallestsum);
            System.out.println();
            System.out.println("----------------------------------------------");

        }
        System.out.println("Total subaarays is : " + tp);
        System.out.println("Max sum of all subarray is : " + maxsum);
        System.out.println("Min sum of all subarray is : " + minsum);

    }

    public static void main(String args[]) {

        // print subarray & max,min sum
        int num[] = { 2, 4, 6, 8, 10 };
        subarray(num);

        // pair an array
        // int num[] = { 2, 4, 6, 8, 10 };
        // pairarray(num);

        // reverse array
        // int num[] = { 2, 4, 6, 8, 10 };

        // reversearray(num);
        // for (int i = 0; i < num.length; i++) {
        // System.out.print(num[i] + " ");
        // }

        // binary search
        // int num[] = { 2, 8, 34, 56, 67, 78, 99 };
        // int key = 8;
        // System.out.println("key found at index : " + binarysearch(num, key));

        // largest number
        // int num[] = { 2, 8, 99, 6, 121 };
        // largestnumber(num);

        // linear search
        // int num[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        // int key = 10;

        // linearSearch(num, key);

        // passing array as an arguments
        // int marks[] = { 99, 97, 98 };
        // update(marks);

        // for (int i = 0; i < marks.length; i++) {
        // System.out.println(marks[i]);
        // }
        // Array creation
        // int marks[] = new int[10];
        // int nums[] = { 1, 2, 3 };

        // Scanner s = new Scanner(System.in);

        // marks[0] = s.nextInt();
        // marks[1] = s.nextInt();
        // marks[2] = s.nextInt();

        // System.out.println("marks :" + marks[0]);
        // System.out.println("marks :" + marks[1]);
        // System.out.println("marks :" + marks[2]);
        // System.out.println("percenteage:" + (marks[0] + marks[1] + marks[2]) / 3);
        // System.out.println(marks.length);
    }
}