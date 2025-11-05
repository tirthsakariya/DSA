public class FriendsPairingProblem {

    public static int friendsPairing(int n) {

        // base case
        if (n == 1 || n == 2) {
            return n;
        }

        // work (kaam)
        // choice single or pain
        int singlechoice = friendsPairing(n - 1);
        int pairchoice = (n - 1) * friendsPairing(n - 2);
        int totalways = singlechoice + pairchoice;
        return totalways;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Ttotal ways for friends pairing : " + friendsPairing(n));
    }
}
