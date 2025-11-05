import java.util.*;

public class ArraylistPractice {

    // most frequent number following key
    public static int mostFrequentNumber(ArrayList<Integer> list, int key) {
        int table[] = new int[1001];
        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i) == key) {
                table[list.get(i + 1)]++; // storing frequency in array
            }
        }

        // finding the index of gretest frequency in table
        int target = 0;
        int max = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] > max) {
                target = i;
                max = table[i];
            }
        }
        return target;
    }

    // lonely numbers in Arraylist
    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> nums) {

        // storing result
        ArrayList<Integer> res = new ArrayList<>();

        Collections.sort(nums);

        for (int i = 0; i < nums.size(); i++) {
            if (i != 0 && ((nums.get(i) - 1 == nums.get(i - 1)) || (nums.get(i) == nums.get(i - 1)))) {
                continue;
            }
            if (i != nums.size() - 1 && ((nums.get(i) + 1 == nums.get(i + 1)) || (nums.get(i) == nums.get(i + 1)))) {
                continue;
            }
            res.add(nums.get(i));
        }
        return res;
    }

    // Beutiful arraylist
    public static ArrayList<Integer> beutifulArrayList(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            int ans_size = ans.size();

            // element generation
            for (int i = 0; i < ans_size; i++) {
                // odd element generation
                if ((ans.get(i) * 2 - 1) <= n) {
                    temp.add(ans.get(i) * 2 - 1);
                }
            }
            for (int i = 0; i < ans_size; i++) {
                // even element generation
                if ((ans.get(i) * 2) <= n) {
                    temp.add(ans.get(i) * 2);
                }
            }
            ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        // most frequent number following key
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(100);
        // list.add(200);
        // list.add(1);
        // list.add(100);
        // list.add(10);
        // int key = 1;
        // System.out.println(mostFrequentNumber(list, key));

        // lonely numbers in Arraylist
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(10);
        // nums.add(6);
        // nums.add(5);
        // nums.add(8);
        // // nums.add(100);
        // // nums.add(10);
        // System.out.println(lonelyNumbers(nums));

        // beutiful ArrayList
        System.out.println(beutifulArrayList(4));
    }
}
