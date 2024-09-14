package Arrays;
// Initial Template for Java
import java.io.*;
import java.util.*;

public class Kadane_algo {
    //{ Driver Code Starts

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
            while (t-- > 0) {

                String line = br.readLine();
                String[] tokens = line.split(" ");

                // Create an ArrayList to store the integers
                ArrayList<Integer> array = new ArrayList<>();

                // Parse the tokens into integers and add to the array
                for (String token : tokens) {
                    array.add(Integer.parseInt(token));
                }

                int[] arr = new int[array.size()];
                int idx = 0;
                for (int i : array) arr[idx++] = i;

                Kadane_algo obj = new Kadane_algo();

                // calling maxSubarraySum() function
                System.out.println(obj.maxSubarraySum(arr));
            }
        }

        // arr: input array
        // Function to find the sum of contiguous subarray with maximum sum.
        long maxSubarraySum(int[] arr) {

            // Your code here
            int n = arr.length;
            int max_so_far = Integer.MIN_VALUE;
            int sum_till_cur = 0;

            for (int i = 0; i < n; i++) {

                sum_till_cur += arr[i];

                if(sum_till_cur > max_so_far) {
                    max_so_far = sum_till_cur;
                }

                if(sum_till_cur < 0) {
                    sum_till_cur = 0;
                }

            }
            return max_so_far;

    }

    int minJumps(int[] arr, int n){
            int min_jumps = 0;

            //Initialize
            int max_reach = arr[0];
            int steps = arr[0];
            min_jumps = 1;

            for (int i = 1; i < n; i++) {

                if(i + arr[i] >= n) {
                    return min_jumps;
                }

                max_reach = Math.max(max_reach, arr[i] + i);

                steps--;

                if(steps == 0) {
                    min_jumps++;

                    if (i >= max_reach)
                        return -1;

                    steps = max_reach - i;
                }
            }

            return min_jumps;
    }

    public int countBuildings(int[] height) {

        // code here
        int max_buildings = 0;
        int max_h = 0;

        for (int i=0; i<height.length; i++)
        {
            if (height[i] >= max_h) {
                max_h = height[i];
                max_buildings++;
            }
        }


        return max_buildings;
    }
}
