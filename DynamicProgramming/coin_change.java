package DynamicProgramming;

import java.util.Arrays;

public class coin_change {

        static int minCoins(int coins[], int m, int sum) {

            int dp_sum_arr[] = new int[sum + 1];

            Arrays.fill(dp_sum_arr, sum + 1);
            Arrays.sort(coins);

            dp_sum_arr[0] = 0;

            for (int i = 0; i < m; i++) {
                for (int j = coins[i]; j <= sum; j++) {
                    dp_sum_arr[j] = Math.min(dp_sum_arr[j - coins[i]] + 1, dp_sum_arr[j]);
                }
            }

            return ( dp_sum_arr[sum] <= sum ? dp_sum_arr[sum] : -1);
        }

        public static void main(String args[])
        {
            int coins[] =  {9, 6, 5, 1};
            int m = coins.length;
            int sum = 11;
            System.out.println("Minimum coins required is "+ minCoins(coins, m, sum) );
        }

}
