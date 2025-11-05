import java.util.*;

public class Heap {

    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(logn)
            // add at last index
            arr.add(data);

            int x = arr.size() - 1; // x is child idx
            int par = (x - 1) / 2; // par idx

            while (arr.get(x) < arr.get(par)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // move up the tree
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // step 1:- swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2:- delete last
            arr.remove(arr.size() - 1);

            // step 3:- heapify
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // heap sort
    public static void heapSort(int arr[]) {
        // step 1 - build maxheap
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step 2 - push largest at end
        for (int i = n - 1; i >= 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    // nearby cars
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    // connect n ropes
    public static void connectNRopes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }

        System.out.println("Cost of connecting N ropes : " + cost);
    }

    // weekest soldiers
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }

    public static void weekestSoldiers(int arr[][], int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[0].length; j++) {
                count += arr[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.err.println("R" + pq.remove().idx);
        }
    }

    // sliding window maximum
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p2) {
            // desending order
            return p2.val - this.val;
        }
    }

    public static void slidingWinMax(int arr[], int k) {
        int res[] = new int[arr.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));

            res[i - k + 1] = pq.peek().val;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        // heap arr = new heap();

        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // arr.add(10);
        // arr.add(1);

        // while (!arr.isEmpty()) {
        // System.out.print(arr.peek() + " ");
        // arr.remove();
        // }

        // heap sort
        // int arr[] = { 1, 2, 4, 5, 3 };
        // heapSort(arr);

        // for (int i = 0; i < arr.length; i++) {
        // System.err.print(arr[i] + " ");
        // }

        // nearby cars
        // int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        // int k = 2;

        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for (int i = 0; i < pts.length; i++) {
        // int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
        // pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        // }

        // // nearest k cars
        // for (int i = 0; i < k; i++) {
        // System.out.println("C" + pq.remove().idx);
        // }

        // connecting n ropes
        // int ropes[] = { 2, 3, 3, 4, 6 };
        // connectNRopes(ropes);

        // weekest soldiers
        // int arr[][] = {
        // { 1, 0, 0, 0 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 0, 0 },
        // { 1, 0, 0, 0 }
        // };
        // int k = 2;
        // weekestSoldiers(arr, k);

        // sliding window maximum
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        slidingWinMax(arr, k);
    }
}
