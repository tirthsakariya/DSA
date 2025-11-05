public class Backtracking {

    public static void changeArr(int arr[], int i /* ,int val */) {
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion (kamm , work)
        // arr[i] = val;
        changeArr(arr, i + 1/* ,val+1 */); // fnx call step
        arr[i] = arr[i] - 2; // Backtracking

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Subsets of String

    public static void subsets(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // recursion (work ,kaam)

        // yes choice
        subsets(str, ans + str.charAt(i), i + 1);

        // no choice
        subsets(str, ans, i + 1);
    }

    // Permutation of String

    public static void perumtations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        // recursion (work , kaam)

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i + 1);
            perumtations(Newstr, ans + curr);
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5 };
        // changeArr(arr, 0/* ,1 */);
        // printArr(arr);

        String str = "abc";
        // subsets(str, "", 0);
        perumtations(str, "");
    }
}
