import java.util.*;

public class Hashing {

    // Majority Element 2
    public static void majorityElement(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }

    // valid anagram
    public static boolean validAnagaram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    // count distinct element
    public static void countDistEle(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.err.println("ans = " + set.size());
    }

    // union & intersection of 2 arrays
    public static void uniIntsec2Arr(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        // union
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.err.println("union = " + set.size());

        set.clear();

        // intersection
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.err.println("intersection = " + count);
    }

    // find itinary from tickets;

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // start point
            }
        }
        return null;
    }

    public static void findItinary(HashMap<String, String> tickets) {
        String start = getStart(tickets);

        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }

        System.out.println();
    }

    // largest subarray with 0 sum
    public static void largestSubArr0Sum(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (sum == 0) {
                len = j + 1;
            }
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        System.err.println("Largest subarray with sum 0 is => " + len);
    }

    // subarray sum equals to k
    public static void subArrSumK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // create
        // HashMap<String, Integer> hm = new HashMap<>();

        // // insert
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Indonesia", 6);
        // hm.put("Nepal", 5);

        // System.out.println(hm);

        // // get
        // int population = hm.get("India");
        // System.out.println(population);

        // // conatains key
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Indonesia"));

        // // remove
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        // // size
        // System.out.println(hm.size());

        // // isEmpty
        // System.out.println(hm.isEmpty());

        // // clear -> used to clear / empty the hashmap
        // hm.clear();
        // System.out.println(hm.isEmpty());

        // iteration on hashmap
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        // System.out.println("key = " + k + ", value = " + hm.get(k));
        // }

        // System.out.println(hm.entrySet()); // with this it also same work like loop
        // but it gives you full pair

        // Linkedhashmmap
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India", 100);
        // lhm.put("China", 150);
        // lhm.put("US", 50);

        // System.out.println(lhm);

        // TreeMap<String, Integer> tm = new TreeMap<>();
        // tm.put("India", 100);
        // tm.put("China", 150);
        // tm.put("US", 50);
        // System.out.println(tm);

        // Majority Element 2
        // int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // majorityElement(arr);

        // valid anagram
        // String s = "race";
        // String t = "care";
        // System.out.println(validAnagaram(s, t));

        // HashSet
        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(3);
        // set.add(4);
        // set.add(5);

        // System.out.println(set);

        // // ops.
        // System.out.println(set.contains(2));

        // System.out.println(set.remove(2));

        // System.out.println(set.size());

        // set.clear();

        // System.out.println(set.isEmpty());

        // Iteration on HashSet
        // A. using iterator
        // HashSet<String> cities = new HashSet<>();

        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Noida");
        // cities.add("Bengaluru");

        // System.out.println(cities);

        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        // // B. using advance loop
        // for(String city:cities){
        // System.out.println(city);
        // }

        // linked hashset
        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Mumbai");
        // lhs.add("Noida");
        // lhs.add("Bengaluru");

        // System.out.println(lhs);

        // // tree hash set
        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Delhi");
        // ts.add("Mumbai");
        // ts.add("Noida");
        // ts.add("Bengaluru");

        // System.out.println(ts);

        // count distinct element;
        // int arr[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // countDistEle(arr);

        // union & intersection of 2 arrays
        // int arr1[] = { 7, 3, 9 };
        // int arr2[] = { 6, 3, 9, 2, 9, 4 };
        // uniIntsec2Arr(arr1, arr2);

        // find itinary from tickets;
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("chennai", "bengaluru");
        // tickets.put("mumbai", "delhi");
        // tickets.put("goa", "chennai");
        // tickets.put("delhi", "goa");

        // findItinary(tickets);

        // largest subarray with 0 sum
        // int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        // largestSubArr0Sum(arr);

        // subarray sum equals to k
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        subArrSumK(arr, k);
    }
}
