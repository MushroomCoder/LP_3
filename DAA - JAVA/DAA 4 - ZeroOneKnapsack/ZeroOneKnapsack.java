public class ZeroOneKnapsack {
    public int knapSack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack knapsackSolver = new ZeroOneKnapsack();

        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;

        int maxProfit = knapsackSolver.knapSack(profits, weights, capacity);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
