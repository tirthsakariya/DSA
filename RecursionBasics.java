public class RecursionBasics {

    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fn = factorial(n - 1);
        return n * fn;
    }

    public static int sumOfN(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = sumOfN(n - 1);
        return n + sum;
    }

    // calculate n th term of fibonacci
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fnum1 = fibonacci(n - 1);
        int fnum2 = fibonacci(n - 2);
        int fnum = fnum1 + fnum2;
        return fnum;
    }

    // array is sorted or not ?
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // first occurence of an element
    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    // last occurence of an element
    public static int lastOccurence(int arr[], int key, int i) {
        if (i < 0) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return lastOccurence(arr, key, i - 1);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xnm1 = power(x, n - 1);
        int xn = x * xnm1;
        return xn;
    }

    public static int optimizedPower(int a, int n) { // O(logn)
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(a, n / 2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {

            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        // int n = 5;
        int arr[] = { 1, 2, 2, 3, 3, 4, 3, 5 };
        int i = arr.length - 1;
        int key = 3;

        // printDec(n);
        // printInc(n);
        // System.out.print(factorial(n));
        // System.out.print(sumOfN(n));
        // System.out.println(fibonacci(n));
        // System.out.println(isSorted(arr, i));
        // System.out.println(firstOccurence(arr, key, i));
        // System.out.println(lastOccurence(arr, key, i));
        System.out.println(power(2, 10));
        System.out.println(optimizedPower(2, 10));

    }
}
