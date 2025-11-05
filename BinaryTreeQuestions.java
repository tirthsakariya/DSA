import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeQuestions {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // make class named Info and return its object in function
    private static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    private static class info {
        Node node;
        int hd;

        public info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // height of a tree -> O(N)
    public static int heightOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        int height = Math.max(lh, rh) + 1;

        return height;
    }

    // count of a Nodes in tree -> O(N)
    public static int countOfNodes(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int lcount = countOfNodes(root.left);
        int rcount = countOfNodes(root.right);

        int treeCount = lcount + rcount + 1;

        return treeCount;
    }

    // diameter of tree approch 2 :- O(N)

    // Sum of a Nodes in tree -> O(N)
    public static int sumOfNodes(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int lsum = sumOfNodes(root.left);
        int rsum = sumOfNodes(root.right);

        int treesum = lsum + rsum + root.data;

        return treesum;
    }

    // diameter of tree approch 1 :- O(N^2)
    public static int diameterOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // calculate diameter of left sub tree and right sub tree
        int ldiam = diameterOfTree(root.left);
        int rdiam = diameterOfTree(root.right);

        // calculateing height of left sub tree and right sub tree
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        // assuming diameter passes through root node
        int selfDiam = lh + rh + 1;

        // compareing 3 to find which is max left subtree or right subtree orselfthrough
        int diameter = Math.max(selfDiam, Math.max(ldiam, rdiam));
        return diameter;

    }

    // Subtree of another tree

    public static Info diameterOfTree2(Node root) {
        // base case
        if (root == null) {
            return new Info(0, 0);
        }

        // making class 's object and uses recursion
        Info leftInfo = diameterOfTree2(root.left);
        Info rightInfo = diameterOfTree2(root.right);

        // calculateing height
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        // calculating diameter
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }

        // checking node or subroot == null or node -> data doesn't match subroot ->
        // data then false
        else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        // checking left subtree is non - identical then false
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }

        // checking right subtree is non - identical then false
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    // Top view of a binary tree

    public static boolean isSubtree(Node root, Node subRoot) {
        // base case
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subRoot); // in left sunbtree exists then return true
        boolean rightAns = isSubtree(root.right, subRoot); // in right sunbtree exists then return true

        // return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        return leftAns || rightAns;
    }

    public static void topViewOfTree(Node root) {
        // Level order traversal and here we creating queue(for travering) and map
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        // first adding root node with info class 's object
        q.add(new info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }

            // main conditions for top view and hd
            else {

                if (!map.containsKey(curr.hd)) { // first btime hd is occuring
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    // kth level of binary tree
    public static void kthLevel(Node root, int level, int k) {
        // base case
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthLevel(root.left, level + 1, k);

        kthLevel(root.right, level + 1, k);
    }

    // lowest common ancesestor approch :- 1 -> TC :- O(N) SC :- O(N)

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // base case
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;

    }

    public static Node lca1(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancesestor

        Node lca = null;
        int i = Math.min(path1.size(), path2.size()) - 1;
        for (; i >= 0; i--) {
            if (path1.get(i) == path2.get(i)) {
                lca = path1.get(i);
                break;
            }
        }

        return lca;
    }

    // lowest common ancesestor approch :- 2 -> TC :- O(N) SC :- O(1)

    public static Node lca2(Node root, int n1, int n2) {

        // base case // checks or compares data
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // if leftLca is valid val but rightInfo = null
        if (rightLca == null) {
            return leftLca;
        }

        // if rightLca is valid val but leftLca = null
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    // Minimum distance betwwn Nodes

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        else if (leftDist == -1) {
            return rightDist + 1;
        }

        else {
            return leftDist + 1;
        }
    }

    public static int minDistBtwNodes(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    // Kth ancestor of node
    public static int kthAncestor(Node root, int n, int k) {
        // base cases
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }
        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // transform to sum tree
    public static int transToSumTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transToSumTree(root.left);
        int rightChild = transToSumTree(root.right);

        int data = root.data;

        int leftData = (root.left != null) ? root.left.data : 0;
        int rightData = (root.right != null) ? root.right.data : 0;
        root.data = leftData + leftChild + rightData + rightChild;
        return data;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // height of a tree
        // System.out.println(heightOfTree(root));

        // count of a Nodes in tree
        // System.out.println(countOfNodes(root));

        // sum of a Nodes in tree
        // System.out.println(sumOfNodes(root));

        // diameter of tree approch 1 :- O(N^2)
        // System.out.println(diameterOfTree(root));

        // diameter of tree approch 2 :- O(N)
        // System.out.println(diameterOfTree2(root).diam);
        // System.out.println(diameterOfTree2(root).ht);

        // Subtree of another tree
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubtree(root, subRoot));

        // Top view of a binary tree
        // topViewOfTree(root);

        // kth level of binary tree
        // kthLevel(root, 1, 3);

        // lowest common ancesestor approch :- 1 -> TC :- O(N) SC :- O(N)
        // System.out.println(lca1(root, 4, 6).data);

        // lowest common ancesestor approch :- 2 -> TC :- O(N) SC :- O(1)
        // System.out.println(lca2(root, 4, 6).data);

        // Minimum distance betwwn Nodes
        // System.out.println(minDistBtwNodes(root, 4, 5));

        // Kth ancestor of node
        // kthAncestor(root, 5, 2);

        // transform to sum tree
        transToSumTree(root);
        preorder(root);
    }
}
