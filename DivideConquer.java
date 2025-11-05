import java.util.Arrays;

public class DivideConquer {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Merge Sort

    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // work(kaam)
        int mid = si + (ei - si) / 2; // mid = si +ei /2
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid + 1, ei); // right part
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // // iterator for temp arr

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
            // k++;
        }

        // left paet
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Quick Sort

    public static void quickSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // last element
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx - 1); // left part
        quickSort(arr, pidx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    // Search in Rotated Sorted array

    public static int searchInRotatedSortedMatrix(int arr[], int tar, int si, int ei) {

        // modified binary search

        // base case
        if (si > ei) {
            return -1;
        }

        // work(kamm)
        int mid = si + (ei - si) / 2; // si+ ei/2

        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a: left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return searchInRotatedSortedMatrix(arr, tar, si, mid);
            } else {
                // case b: right
                return searchInRotatedSortedMatrix(arr, tar, mid + 1, ei);
            }
        }

        // mid on L2
        else {
            // case c: right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return searchInRotatedSortedMatrix(arr, tar, mid + 1, ei);
            } else {
                // case d : left
                return searchInRotatedSortedMatrix(arr, tar, si, mid - 1);
            }
        }
    }

    // Merge sort on array of String

    public static void mergesortArrOfString(String arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // work(kaam)
        int mid = (si + ei) / 2;
        mergesortArrOfString(arr, si, mid);
        mergesortArrOfString(arr, mid + 1, ei);
        mergeArrOfString(arr, si, mid, ei);
    }

    public static void mergeArrOfString(String arr[], int si, int mid, int ei) {
        // two pointer staratagy
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0;
        String res[] = new String[ei - si + 1];

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                res[k] = arr[i];
                i++;
                k++;
            } else {
                res[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            res[k] = arr[i];
            i++;
            k++;
        }

        while (j <= ei) {
            res[k] = arr[j];
            j++;
            k++;
        }

        for (int idx = 0; idx < res.length; idx++) {
            arr[idx + si] = res[idx];
        }
    }

    // Majority element with boyer - more voting algo not with dividde and conqer

    public static int majorityElement(int nums[]) {
        int winner = nums[0], lead = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == winner) {
                lead++;
            } else if (lead > 0) {
                lead--;
            } else {
                winner = nums[i];
                lead = 1;
            }
        }
        return winner;
    }

    public static void inversionCount(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i < j) {
                    if (arr[i] > arr[j]) {
                        count++;
                        System.out.print("(" + arr[i] + "," + arr[j] + ")");
                    }
                }

            }
        }
        System.out.println();
        System.out.println("Total inversion count is : " + count);
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        // int target = 0;
        // String arr[] = { "sun", "earth", "mars", "mercury" };
        // mergesortArrOfString(arr, 0, arr.length - 1);
        // System.out.print(Arrays.toString(arr));
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);
        // System.out.println(searchInRotatedSortedMatrix(arr, target, 0, arr.length -
        // 1));
        // printArr(arr);
        // int nums[] = { 20, 20, 10, 30, 20, 30, 30, 30, 30, 10 };
        // System.out.println(majorityElement(nums));
        int arr[] = { 2, 4, 1, 3, 5 };
        inversionCount(arr);
    }
}
