import java.util.ArrayList;

public class ContainerWithMostWater {

    // brute force
    public static int containerWithMostWater1(ArrayList<Integer> height) {
        int maxWater = 0;

        // brute force O(n^2)
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {

                // height of container
                int ht = Math.min(height.get(i), height.get(j));

                // width of container
                int wt = j - i;

                // current water stored in current pair
                int currWater = ht * wt;

                // comparing currwater and maxwater who is greter
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    // 2 pointer approch
    public static int containerWithMostWater2(ArrayList<Integer> height) {
        int maxWater = 0;

        // take 2 pointers
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            // // height of container
            int ht = Math.min(height.get(lp), height.get(rp));

            // width of container
            int wt = rp - lp;

            // current water stored in current pair
            int currWater = ht * wt;

            // comparing currwater and maxwater who is greter
            maxWater = Math.max(maxWater, currWater);

            // conditions of pointers to update ptr
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(containerWithMostWater1(height));
        System.out.println(containerWithMostWater2(height));
    }
}
