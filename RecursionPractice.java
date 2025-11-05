public class RecursionPractice {

    // linear search with recursion
    public static void linearSearchRecursion(int arr[], int key, int idx) {

        // base case
        if (idx == arr.length) {
            return;
        }

        // work (kaam)
        if (arr[idx] == key) {
            System.out.print(idx + " ");
        }
        linearSearchRecursion(arr, key, idx + 1);

    }

    public static void towerOfHonoi(int n, char A, char C, char B) {
        // base case
        if (n == 0) {
            return;
        }

        // work(kaam)
        // step 1 : first we wants to transefer disk 1 and disk 2 to transefer tower a
        // to b with the hepl of towe c (transefering disk a to c then go to b)
        towerOfHonoi(n - 1, A, B, C);
        // step 2 : second we want to do transer disk 3 to tower a to c
        System.out.println("Moving " + n + " disk from " + A + " to " + C);
        // step 3 : third we want to transefer disk 1 and disk 2 to transefer tower b to
        // c with help of a (like first transfer disk to a then transfer disk 2 to c
        // then transfer disk 1 to a to c)
        towerOfHonoi(n - 1, B, C, A);
    }

    // length of string using recursion
    public static int lengthOfString(String str) {
        if (str.length() == 0) {
            return 0;
        }
        return lengthOfString(str.substring(1)) + 1;

    }

    // convert number to english word
    public static void convertToEnglish(int n) {
        String words[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        if (n == 0) {
            return;
        }
        int lastdigit = n % 10;
        convertToEnglish(n / 10);
        System.out.print(words[lastdigit] + " ");
    }

    public static void main(String[] args) {

        // linear search with recursion
        // int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // int key = 2;
        // linearSearchRecursion(arr, key, 0);
        // int n = 3;
        // char A = 'A', B = 'B', C = 'C';
        // towerOfHonoi(n, A, C, B);
        // String str = "tirth";
        // System.out.println(lengthOfString(str));
        int n = 1947;
        convertToEnglish(n);
    }
}
