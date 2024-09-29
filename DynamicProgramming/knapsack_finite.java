package DynamicProgramming;

import java.util.Arrays;

// Infinite quantity of knapsack.

public class knapsack_finite {

        static int knapSack_infinite(int W, int wt[], int val[])
        {
            int n = wt.length;
            // Base Case
            if (n == 0 || W == 0)
                return 0;

           int dp_price[] = new int[W + 1];

            Arrays.sort(wt);
            Arrays.fill(dp_price, 0);

            for (int i=0; i<n; i++) {
                for (int j=wt[i]; j<W+1;j++) {
                    dp_price[j] = Math.max( dp_price[j - wt[i]] + val[i], dp_price[j]);
                }

            }

            return dp_price[W];
        }

    static int knapSack(int W, int wt[], int val[])
    {
        int n = wt.length;
        int max = 0;

        // Base Case
        if (n == 0 || W == 0)
            return 0;

        int dp_price[][] = null;

        try {

            dp_price = new int[n + 1][W + 1];

            for (int i = 0; i < W + 1; i++) {
                dp_price[0][i] = 0;
            }

            for (int i = 0; i < n + 1; i++) {
                dp_price[i][0] = 0;
            }


            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < W + 1; j++) {

                    if (j < wt[i - 1])
                        dp_price[i][j] = dp_price[i-1][j];
                    else
                        dp_price[i][j] = Math.max(dp_price[i - 1][j - wt[i - 1]] + val[i - 1], dp_price[i-1][j]);

                    if(dp_price[i][j] > max)
                        max = dp_price[i][j];
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return max;
    }

    // Driver code
        public static void main(String args[])
        {
            int profit[] = new int[] { 10, 8, 6 };
            int weight[] = new int[] { 1, 7, 9 };
            int W = 7;
            int n = profit.length;
            System.out.println(knapSack(W, weight, profit));
        }

}
