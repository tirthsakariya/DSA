import java.util.*;

public class Subarray {

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

    public static void main(String[] args) {
        // print subarray & max,min sum
        int num[] = { 2, 4, 6, 8, 10 };
        subarray(num);
    }
}
