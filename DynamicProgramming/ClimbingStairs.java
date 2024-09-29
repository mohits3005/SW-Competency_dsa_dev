package DynamicProgramming;

public class ClimbingStairs {

    static int countWays(int n)
    {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // Driver method
    public static void main(String[] args)
    {
        int n = 84;
        System.out.println("Number of ways = "
                + countWays(n));
    }

}


