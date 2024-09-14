package Arrays;

import java.io.*;
import java.util.*;

public class Kadane_algo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] tokens = br.readLine().split(" ");
            int[] arr = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();

            Kadane_algo obj = new Kadane_algo();
            System.out.println(obj.maxSubarraySum(arr));
        }
    }

    long maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0], currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    int minJumps(int[] arr, int n) {
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int maxReach = arr[0], steps = arr[0], jumps = 1;

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }

        return -1;
    }

    public int countBuildings(int[] height) {
        int maxBuildings = 0, maxHeight = 0;

        for (int h : height) {
            if (h > maxHeight) {
                maxHeight = h;
                maxBuildings++;
            }
        }

        return maxBuildings;
    }
}
