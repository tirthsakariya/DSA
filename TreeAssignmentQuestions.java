import java.util.*;

public class TreeAssignmentQuestions {
    
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    // Delete leaf node with x value
    public static Node deleteNleaves(Node root,int x){
        if(root == null){
            return null;
        }
        
        root.left = deleteNleaves(root.left,x);
        root.right = deleteNleaves(root.right,x);
        
        if(root.data == x && root.left == null && root.right == null){
            return null;
        }
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
    
    // find all duplicates in subtree
    static HashMap<String,Integer>m;
    
    public static String duplicateInSubtree(Node root){
        if(root == null){
            return "";
        }
        // inorder traversal
        String str = "(";
        str += duplicateInSubtree(root.left);
        str += Integer.toString(root.data);
        str += duplicateInSubtree(root.right);
        str += ")";
        
        if(m.get(str) != null && m.get(str) == 1){
            System.out.println(str + " ");
        }
        
        if(m.containsKey(str)){
            m.put(str,m.get(str) + 1);
        }
        else{
            m.put(str,1);
        }
        return str;
    }
    
    // maximum path sum in binary tree
    static int val;
    public static int maxPathSum(Node root){
        // base case
        if(root == null){
            return 0;
        }
        
        // find max in left sub tree
        int l = maxPathSum(root.left);
        
        // find max in right sub tree
        int r = maxPathSum(root.right);
        
        // find max sum height starting from root
        int max_single = Math.max(Math.max(l,r) + root.data, root.data);
        
        // find max sum path containing this node
        int max_top = Math.max(max_single, l + r + root.data);
        
        // store max path
        val = Math.max(val, max_top);
        
        // return max sum height
        return max_single;
        
    }
    
    public static int maxPathSumInBt(Node root) {
    val = Integer.MIN_VALUE; // initialize before starting
    maxPathSum(root);
    return val;
}
    
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        
        //Node root = new Node(1);
        //root.left = new Node(3);
        //root.right = new Node(3);
        //root.left.left = new Node(3);
        //root.left.right = new Node(2);
        //deleteNleaves(root,3);
        //preorder(root);
        
        //Node root = new Node(1);
        //root.left = new Node(4);
        //root.right = new Node(3);
       // root.left.left = new Node(3);
       // root.left.right = new Node(5);
        //root.right.left = new Node(4);
        //root.right.right = new Node(3);
        //root.right.left.left = new Node(3);
       // m = new HashMap<>();
        //duplicateInSubtree(root);
        
        System.out.println(maxPathSumInBt(root));
    }
}