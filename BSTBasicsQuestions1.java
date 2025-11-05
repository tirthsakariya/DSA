import java.util.*;

public class BSTBasicsQuestions1 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // build a binary search tree manually
    public static Node buildBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) { // left subtree
            root.left = buildBST(root.left, val);
        } else { // right subtree
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    // searching in BST
    public static boolean searchBST(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.data) {
            // System.out.println("key found !!!");
            return true;
        }

        boolean left = false;
        boolean right = false;

        if (key < root.data) {
            left = searchBST(root.left, key);
        } else {
            right = searchBST(root.right, key);
        }
        return left || right;
    }

    // Deleting a perticylar node in BST
    public static Node deleteNode(Node root, int val) {
        if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else {
            // root.data == val
            // case 1 -> leaf node to null
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 -> single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 -> both (two) children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print a range between k1 and k2
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data <= k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // root to leaf paths
    public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }

        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);

        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    // validate BST
    public static boolean validBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        else if (max != null && root.data >= max.data) {
            return false;
        }

        return validBST(root.left, min, root) && validBST(root.right, root, max);
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

    public static void main(String[] args) {

        // int values[] = {5,1,3,4,2,7};

        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = buildBST(root, values[i]);
        }
        inorder(root);
        System.out.println();

        // if(searchBST(root,7)){
        // System.out.println("key found !!!");
        // }
        // else{
        // System.out.println("key not found !!!");
        // }

        // root = deleteNode(root, 5);
        // System.out.println();
        // inorder(root);

        // printInRange(root, 5, 12);

        // rootToLeafPath(root, new ArrayList<>());

        // System.out.println(validBST(root, null, null));

        root = mirrorBST(root);
        System.out.println();
        preorder(root);
        System.out.println();
        inorder(root);
    }
}