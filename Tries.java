public class Tries {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int lv = 0; lv < word.length(); lv++) {
            int idx = word.charAt(lv) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int lv = 0; lv < key.length(); lv++) {
            int idx = key.charAt(lv) - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String arr[], String key) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(arr, key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    // prefix problem (shortest uniq prefix)
    static class Node1 {
        Node1 child1[] = new Node1[26];
        boolean eow = false;
        int freq;

        public Node1() {
            for (int i = 0; i < 26; i++) {
                child1[i] = null;
            }
            freq = 1;
        }
    }

    public static Node1 root1 = new Node1();

    public static void insert1(String word) {
        Node1 curr = root1;
        for (int lv = 0; lv < word.length(); lv++) {
            int idx = word.charAt(lv) - 'a';
            if (curr.child1[idx] == null) {
                curr.child1[idx] = new Node1();
            } else {
                curr.child1[idx].freq++;
            }
            curr = curr.child1[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(String arr[], Node1 root1, String ans) {

        if (root1 == null) {
            return;
        }

        if (root1.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root1.child1[i] != null) {
                findPrefix(arr, root1.child1[i], ans + (char) (i + 'a'));
            }
        }
    }

    // starts with problem
    public static boolean startsWith(String prefix, String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }

    // count unique substring

    public static void UniqueSubstring(String str) {
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                count += countNodes(root.child[i]);
            }
        }
        return count + 1;
    }

    // longest word of all prefixes
    public static String ans = "";

    public static void longestWordPrefix(String words[], Node root, StringBuilder temp) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) { // a , b, c ,d // alrady smaller laxicography
            if (root.child[i] != null && root.child[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWordPrefix(words, root.child[i], temp);

                // backtrack step
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        // creating , inserting , seraching for trie
        // String words[] = { "the", "a", "there", "their", "any", "thee" };

        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // System.out.println(search("thee"));
        // System.err.println(search("a"));

        // word break problem
        // String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        // String key = "ilikesamsung";

        // System.out.println(wordBreak(arr, key));

        // prefix problem
        // String arr[] = { "zebra", "dog", "duck", "dove" };
        // for (int i = 0; i < arr.length; i++) {
        // insert1(arr[i]);
        // }
        // root1.freq = -1;
        // findPrefix(arr, root1, "");

        // starts with problem
        // String arr[] = { "apple", "app", "mango", "man", "woman" };
        // String pref1 = "app";
        // String pref2 = "moon";

        // System.out.println(startsWith(pref1, arr));
        // System.out.println(startsWith(pref2, arr));

        // count unique substring
        // String str = "ababa";
        // UniqueSubstring(str);

        // longest word of all prefixes
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        longestWordPrefix(words, root, new StringBuilder(""));
        System.out.println(ans);
    }
}