public class SegmentTrees {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    // creation / constructing Segment Tree
    public static int buildST(int[] arr, int start, int end, int node) {
        if (start == end) { // leaf node
            tree[node] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, start, mid, 2 * node + 1);
        buildST(arr, mid + 1, end, 2 * node + 2);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2]; // sum
        return tree[node];
    }

    // query sum in range [l, r]
    public static int query(int arr[], int qi, int qj) {
        return queryUtil(0, arr.length - 1, qi, qj, 0);
    }

    // utility recursive query
    private static int queryUtil(int start, int end, int qi, int qj, int node) {
        // total overlap
        if (qi <= start && end <= qj) {
            return tree[node];
        }
        // no overlap
        if (end < qi || start > qj) {
            return 0;
        }
        // partial overlap
        int mid = (start + end) / 2;
        int left = queryUtil(start, mid, qi, qj, 2 * node + 1);
        int right = queryUtil(mid + 1, end, qi, qj, 2 * node + 2);
        return left + right;
    }

    // update wrapper
    public static void update(int[] arr, int idx, int newVal) {
        int diff = newVal - arr[idx]; // how much to adjust
        arr[idx] = newVal; // reflect change in original array
        updateUtil(0, arr.length - 1, idx, diff, 0);
    }

    // recursive update with cases
    private static void updateUtil(int start, int end, int idx, int diff, int node) {
        // case 1: idx not in this range
        if (idx < start || idx > end) {
            return;
        }

        // case 2: idx lies in range → update this node
        tree[node] += diff;

        // case 3: if leaf node → stop
        if (start == end) {
            return;
        }

        // otherwise recurse
        int mid = (start + end) / 2;
        updateUtil(start, mid, idx, diff, 2 * node + 1);
        updateUtil(mid + 1, end, idx, diff, 2 * node + 2);
    }

    // creation / constructing Segment Tree
    public static int maxbuildST(int[] arr, int start, int end, int node) {
        if (start == end) { // leaf node
            tree[node] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        maxbuildST(arr, start, mid, 2 * node + 1);
        maxbuildST(arr, mid + 1, end, 2 * node + 2);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]); // sum
        return tree[node];
    }

    // query wrapper
    public static int maxquery(int arr[], int qi, int qj) {
        return queryUtil(0, arr.length - 1, qi, qj, 0);
    }

    // recursive query for max
    private static int maxqueryUtil(int start, int end, int qi, int qj, int node) {
        // total overlap
        if (qi <= start && end <= qj) {
            return tree[node];
        }
        // no overlap
        if (end < qi || start > qj) {
            return Integer.MIN_VALUE; // neutral for max
        }
        // partial overlap
        int mid = (start + end) / 2;
        int left = maxqueryUtil(start, mid, qi, qj, 2 * node + 1);
        int right = maxqueryUtil(mid + 1, end, qi, qj, 2 * node + 2);
        return Math.max(left, right);
    }

    // update wrapper
    public static void maxupdate(int[] arr, int idx, int newVal) {
        arr[idx] = newVal; // reflect change in original array
        updateUtil(0, arr.length - 1, idx, newVal, 0);
    }

    // recursive update with cases
    private static void maxupdateUtil(int start, int end, int idx, int newVal, int node) {
        // case 1: idx not in this range
        if (idx < start || idx > end) {
            return;
        }

        // case 2: leaf node
        if (start == end) {
            tree[node] = newVal;
            return;
        }

        // otherwise recurse
        int mid = (start + end) / 2;
        maxupdateUtil(start, mid, idx, newVal, 2 * node + 1);
        maxupdateUtil(mid + 1, end, idx, newVal, 2 * node + 2);

        // update this node after child updates
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        init(n);
        // buildST(arr, 0, n - 1, 0);

        // for (int i = 0; i < tree.length; i++) {
        // System.out.print(tree[i] + " ");
        // }

        // System.out.println("\nSum(2,5): " + query(arr, 2, 5)); // 3+5+7 = 15
        // update(arr, 2, 2);
        // System.out.println("Sum(2,5): " + query(arr, 2, 5));

        maxbuildST(arr, 0, n - 1, 0);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println("\nSum(2,5): " + maxquery(arr, 2, 5)); // 3+5+7 = 15
        maxupdate(arr, 2, 2);
        System.out.println("Sum(2,5): " + maxquery(arr, 2, 5));
    }
}
