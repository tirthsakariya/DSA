import java.util.*;

public class Arraylist {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // add operation O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // // other add function
        // list.add(1, 9);

        // System.out.println(list);

        // // Get operation O(1)
        // list.get(2);
        // System.out.println(list.get(2));

        // // remove operation O(n)
        // list.remove(2);
        // System.out.println(list);

        // // set operation O(n)
        // list.set(2, 10);
        // System.out.println(list);

        // // contains operation O(n)
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(11));

        // // size of Arraylist
        // System.out.println(list.size());

        // // print the arraylist
        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        // // reverse of arraylist O(n)
        // for (int i = list.size() - 1; i >= 0; i--) {
        // System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        // // maximum in arraylist O(n)
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        // if (max < list.get(i)) {
        // max = list.get(i);
        // }
        // // or
        // // max = Math.max(max,list.get(i));
        // }
        // System.out.println(max);

        // swap 2 numbers
        // int idx1 = 1, idx2 = 3;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        // // sorting on arraylist
        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // multidimensional arraylist
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> lst = new ArrayList<>();
        // lst.add(1);
        // lst.add(2);
        // mainList.add(lst);

        // ArrayList<Integer> lst2 = new ArrayList<>();
        // lst2.add(3);
        // lst2.add(4);
        // mainList.add(lst2);

        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);
        // for (int j = 0; j < currList.size(); j++) {
        // System.out.print(currList.get(j) + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(mainList);

        // multidimensional arraylist ques
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        ArrayList<Integer> lst3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            lst1.add(i * 1);
            lst2.add(i * 2);
            lst3.add(i * 3);
        }

        mainList.add(lst1);
        mainList.add(lst2);
        mainList.add(lst3);

        System.out.println(mainList);

        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }
}
