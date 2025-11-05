public class BuySellStocks {

    public static int buyAndSellStocks(int prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {
            int sellprice = prices[i];
            if (buyprice < sellprice) {// profit
                int profit = sellprice - buyprice; // today 's profit
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buyprice = prices[i];
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 5, 1, 3, 6, 4 };
        System.out.println("Maximum profit is = " + buyAndSellStocks(prices));
    }
}