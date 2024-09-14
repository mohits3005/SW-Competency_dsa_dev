package Arrays;

import java.io.*;
import java.util.*;

public class Subset_sum_all {
    //{ Driver Code Starts

        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while(t-->0)
            {
                int n = sc.nextInt();
                int sum = sc.nextInt();
                int arr[] = new int[n];
                for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();

                Subset_sum_all ob = new Subset_sum_all();
                System.out.println(ob.perfectSum(arr,n,sum));
            }
        }

    public int perfectSum(int arr[],int n, int sum) {
        // Your code goes here
        int totalsubsets = 0;

        int start = 0;
        int sum_till_now = 0;

        for (int i = 0; i < n; i++) {
            sum_till_now += arr[i];

            if (sum_till_now == sum) {
                totalsubsets++;
            } else if (sum_till_now > sum) {

                while (sum_till_now > sum && start <= i) {
                    sum_till_now -= arr[start];
                    start++;
                }

                if (sum_till_now == sum) {
                    totalsubsets++;
                }
            }
        }

        return totalsubsets;
    }

}
