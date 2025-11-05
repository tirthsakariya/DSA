import java.util.*;

public class GreedyAlgoQuestions {

    // activity selection
    public static void activitySelection(int start[], int end[]) {
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1ST activity adding into ans and inc. maxAct
        maxAct = 1;
        ans.add(0);

        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) { // imp conditions... cond is if it is non overlapping then cond works
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max Activities : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void activitySelectionUnsortedEnd(int start[], int end[]) {
        // sorting process
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);

        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) { // imp conditions... cond is if it is non overlapping then cond works
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Activities : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    // fractional knapsack
    public static void fractionalKnapsack(int val[], int weight[], int w) {

        // sorting for 2d ratio
        double ratio[][] = new double[val.length][2];
        // 0th col => original idx ; 1st col -> ratio

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // assending order sorting
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // main logic
        int capacity = w;
        int finalVal = 0;

        // for desending order sorting to get higher value
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];

            if (capacity >= weight[idx]) {
                // including full item
                finalVal += val[idx];
                capacity -= weight[idx];
            }

            else {
                // including fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value is : " + finalVal);
    }

    // Min Absoulte differance pairs TC -> O(NlogN)
    public static void minAbsDiffPairs(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minAbsDiff += Math.abs(A[i] - B[i]); // this abs function gives you absolute diff of given values...
        }

        System.out.println("Min Absolute Differance is : " + minAbsDiff);
    }

    // max length of chain of pairs
    public static void maxLenChainOfPairs(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1]; // last selected pair end // chain end

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) { // start > pairend
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Maximum length of chain pair is : " + chainLen);
    }

    // indian coins
    public static void indianCoins(Integer coins[], int amount) {

        // sorting coins in desending order or you can do reverse loop in ascending
        // order
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            // if (coins[i] <= amount) {
            while (coins[i] <= amount) {
                countOfCoins++;
                ans.add(coins[i]);
                amount -= coins[i];
            }
            // }
        }

        System.out.println("total (min) coins used : " + countOfCoins);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    // job sequencing problem

    static class Job {
        int deadline;
        int profit;
        int id; // 0(A) , 1(B) , 2(C) , 3(D)

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void jobSequencingProblem(int jobsInfo[][]) {

        // making class 's object for data storing'
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // desending order sorting

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;

        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        // print seq
        System.out.println("Max jobs : " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
    }

    // chocola problem
    public static void chocolaProblem(Integer costVer[], Integer costHor[], int n, int m) {
        Arrays.sort(costVer, Collections.reverseOrder()); // desending order sorting for both costs
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // pointers for iterating threw costs of hor and ver
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            // vertical cost < hor cost
            if (costVer[v] <= costHor[h]) { // horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            } else {
                cost += (costVer[v] * hp); // vertical cut
                vp++;
                v++;
            }
        }

        // remainng cuts for if stays in Arrays

        while (h < costHor.length) {// horizontal cut for remaining
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while (v < costVer.length) {
            cost += (costVer[v] * hp); // vertical cut for remaining
            vp++;
            v++;
        }

        System.out.println("Minimum cost of all cuts is : " + cost);
    }

    // maximum baklanced string partitions
    public static void maxBalStringPartitions(String str) {
        // int lcount = 0;
        // int rcount = 0;
        int count = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'L') {
                // lcount++;
                count++;
            } else {
                // rcount++;
                count--;
            }

            if (count == 0) {
                ans++;
            }
        }
        System.out.println("Maximum baklanced string partitions is : " + ans);
    }

    // Lexicographically smallest string of length N and sum K
    public static void lexSmallString(int n, int k) {
        StringBuilder sb = new StringBuilder();

        int total_chars = n;
        int csum = k;

        while (total_chars > 0) {
            // is it possible to fill 'a' here
            if ((total_chars - 1) * 26 >= (csum - 1)) {
                sb.append('a');
                csum--;
            }

            else {
                int position = csum % 26;

                if (position == 0) {
                    sb.append('z');
                    csum -= 26;
                }

                else {
                    sb.append((char) (position + 'a'));
                    csum -= position;
                }
            }
            total_chars--;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        // // activity selection
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 }; // end time alrady sorted in queue
        // activitySelection(start, end);
        // activitySelectionUnsortedEnd(start, end);

        // fractional knapsack
        // int val[] = { 60, 100, 120 };
        // int weight[] = { 10, 20, 30 };
        // int w = 50;
        // fractionalKnapsack(val, weight, w);

        // Min Absoulte differance pairs
        // int A[] = { 4, 1, 8, 7 };
        // int B[] = { 2, 3, 6, 5 };
        // minAbsDiffPairs(A, B);

        // max length of chain of pairs
        // int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // maxLenChainOfPairs(pairs);

        // indian coins
        // Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // int amount = 2200;
        // indianCoins(coins, amount);

        // job sequencing problem
        // int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40, }, { 1, 30 } };
        // jobSequencingProblem(jobsInfo);

        // // chocola problem
        // int n = 4, m = 6;
        // Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        // Integer costHor[] = { 4, 1, 2 }; // n-1
        // chocolaProblem(costVer, costHor, n, m);

        // maximum baklanced string partitions
        // String str = "LRRRRLLRLLRLLR";
        // maxBalStringPartitions(str);

        // Lexicographically smallest string of length N and sum K
        int n = 5, k = 42;
        lexSmallString(n, k);
    }
}
