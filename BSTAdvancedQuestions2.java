
import java.util.ArrayList;

public class BSTAdvancedQuestions2 {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // mirror BST
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMirror = mirrorBST(root.left);
        Node rightMirror = mirrorBST(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // sorted array to balanced BST
    public static Node sortedToBalancedBST(int arr[], int st, int end) {
        // base case
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(arr[mid]);

        root.left = sortedToBalancedBST(arr, st, mid - 1);

        root.right = sortedToBalancedBST(arr, mid + 1, end);

        return root;
    }

    // convert BST to balanced BST

    public static void getInoder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }

        getInoder(root.left, inorder);
        inorder.add(root.data);
        getInoder(root.right, inorder);
    }

    public static Node sortedToBalancedBST(ArrayList<Integer> inorder, int st, int end) {
        // base case
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(inorder.get(mid));

        root.left = sortedToBalancedBST(inorder, st, mid - 1);

        root.right = sortedToBalancedBST(inorder, mid + 1, end);

        return root;
    }

    public static Node BSTtoBalancedBST(Node root) {
        // inorder seq.
        ArrayList<Integer> inorder = new ArrayList<>();
        getInoder(root, inorder);

        // sorted inorder -> balanced BST
        root = sortedToBalancedBST(inorder, 0, inorder.size() - 1);

        return root;
    }

    // size of largest BST in BT

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBSTSize = 0;

    public static Info largestBSTSize(Node root) {
        // base case
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBSTSize(root.left);
        Info rightInfo = largestBSTSize(root.right);

        int size = leftInfo.size + rightInfo.size + 1;

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));

        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // isbst calculation
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            maxBSTSize = Math.max(maxBSTSize, size);
            return new Info(true, size, min, max);
        } else {
            return new Info(false, size, min, max);
        }
    }

    // merge 2 BSTs

    // taking out inorder(sorted seq)
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // sorted arr to balanced BST
    public static Node balBST(ArrayList<Integer> arr, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node root = new Node(arr.get(mid));

        root.left = balBST(arr, st, mid - 1);

        root.right = balBST(arr, mid + 1, end);

        return root;
    }

    // merging 2 bsts and making balanced bst

    public static Node merge2BSTs(Node root1, Node root2) {
        // step 1 sorted arr1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step 2 sorted arr 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // step 3 merge arr1 and arr2
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // step 4 sorted arraylist to balanced BST
        return balBST(finalArr, 0, finalArr.size() - 1);
    }

    // ---------------------------------------- Assignment
    // questions---------------------------------------------------------------//

    // range sum in bst
    public static void getInorder2(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getInorder2(root.left, arr);
        arr.add(root.data);
        getInorder2(root.right, arr);
    }

    public static int rangeSumOfBST(Node root, int low, int high) {
        ArrayList<Integer> arr = new ArrayList<>();
        getInorder2(root, arr);
        // for (int i = 0; i < arr.size(); i++) {
        // System.out.print(arr.get(i) + " ");
        // }

        int sum = 0;
        int l = arr.indexOf(low);
        int h = arr.indexOf(high);

        for (int i = l; i <= h; i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    // closest element in bst

    public static int closestEleInBST(Node root, int key) {
        ArrayList<Integer> arr = new ArrayList<>();

        // inorder function extracting from upper question
        getInorder2(root, arr);

        int minDiff = Integer.MAX_VALUE;
        int diff = 0;
        int closest = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (key == arr.get(i)) {
                return arr.get(i);
            } else {
                diff = Math.abs(key - arr.get(i));
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = arr.get(i);
                }
            }
        }
        return closest;
    }

    // kth smallest element in BST

    static int prevorder = 0;

    public static int kthSmallest(Node root, int k) {
        if (root == null) {
            return -1;
        }

        if (root.left != null) {
            int leftans = kthSmallest(root.left, k);
            if (leftans != -1) {
                return leftans;
            }
        }
        if (prevorder + 1 == k) {
            return root.data;
        }
        prevorder = prevorder + 1;

        if (root.right != null) {
            int rightans = kthSmallest(root.right, k);
            if (rightans != -1) {
                return rightans;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // [1, 2, 3, 4, 5, 6, 7]

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        // mirror of BST
        // mirrorBST(root);
        // preorder(root);

        // sorted array to balanced BST
        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        // Node root = createBST(arr, 0, arr.length - 1);
        // preorder(root);

        // convert BST to balanced BST
        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.right = new Node(10);
        // root.left.left = new Node(5);
        // root.right.right = new Node(11);
        // root.left.left.left = new Node(3);
        // root.right.right.right = new Node(12);

        // root = BSTtoBalancedBST(root);
        // preorder(root);

        // size of largest BST in BT
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.right = new Node(60);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBSTSize(root);
        // System.out.println("largest BST size in BT : " + maxBSTSize);

        // merge 2 BSTs
        // Node root1 = new Node(2);
        // root1.left = new Node(1);
        // root1.right = new Node(4);

        // Node root2 = new Node(9);
        // root2.left = new Node(3);
        // root2.right = new Node(12);

        // Node root = merge2BSTs(root1, root2);
        // preorder(root);

        // range sum in bst
        // Node root = new Node(10);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.right = new Node(7);
        // root.right = new Node(15);
        // root.right.right = new Node(18);
        // // [3,5,7,10,15,18]

        // System.err.println(rangeSumOfBST(root, 7, 15));

        // closest element in bst
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(18);
        System.out.println(closestEleInBST(root, 5));
    }
}