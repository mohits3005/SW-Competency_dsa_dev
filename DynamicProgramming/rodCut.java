package DynamicProgramming;

import java.util.*;

public class rodCut {

    public static int cutRod(int prices[], int n)
    {
        int dp_prices[] = new int[n + 1];

        Arrays.fill(dp_prices,0);

        for (int i=1; i<n+1; i++)
        {
            // i is len of cut rod
            for (int j=i; j<n + 1; j++) {
                dp_prices[j] = Math.max(dp_prices[j-i] + prices[i - 1], dp_prices[j]);
            }
        }

        return dp_prices[n];
    }


    public static void main(String[] args)
    {

        int prices[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = prices.length;

        System.out.println("Maximum obtained value is "
                + cutRod(prices, n));
    }
}

