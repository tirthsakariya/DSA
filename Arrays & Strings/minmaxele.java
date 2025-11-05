// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class minmaxele {

    public static void maxEle(int arr[], int low, int high) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int mid = (low + high) / 2;
        for (int i = low; i <= mid - 1; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = mid + 1; i < high; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println(min);
        System.out.println(max);
    }

    public static void main(String[] args) {

        int arr[] = { 10, 20, 30, 40, 50, 60 };
        maxEle(arr, 0, arr.length);

    }
}