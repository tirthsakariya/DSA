import java.util.Arrays;

class NextPermutation {
    public void nextPermutation(int[] a) {
        int n = a.length;
        int pivot = -1;

        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If no pivot found, sort the whole array (i.e., reverse order =>
        // lowest permutation)
        if (pivot == -1) {
            Arrays.sort(a);
            return;
        }

        // Step 3: Find the next larger element to swap with pivot
        for (int i = n - 1; i > pivot; i--) {
            if (a[i] > a[pivot]) {
                swap(a, i, pivot);
                break;
            }
        }

        // Step 4: Sort the suffix (pivot+1 to end) to get the next permutation
        Arrays.sort(a, pivot + 1, n);
    }

    // Swap method
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        NextPermutation np = new NextPermutation(); // create object
        np.nextPermutation(a); // call method

        // Print result
        System.out.println(Arrays.toString(a));
    }

}
