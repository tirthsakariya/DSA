public class TrapRainWater {

    public static int trapRainWater(int height[]) {
        int n = height.length;

        // calculate left max boundry - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max boundry - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedwater = 0;

        // loop

        for (int i = 0; i < n; i++) {

            // waterlevel = min(leftmaxboundry , rightmax boundry)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);

            // trappwater = wanterlevel - height[i]
            trappedwater += waterlevel - height[i];
        }

        return trappedwater;
    }

    public static void main(String[] args) {

        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Traped Rain water is = " + trapRainWater(height));
    }
}