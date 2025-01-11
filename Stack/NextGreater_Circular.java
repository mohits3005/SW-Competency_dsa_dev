package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater_Circular {

        public static int[] nextGreaterElements(int[] arr) {
            int nge[] = new int[arr.length];

            Stack<Integer> st = new Stack<>();

            for (int i=0; i<2* arr.length - 1; i++)
            {
                if (!st.isEmpty()) {
                    
                } else {
                    st.push(arr[i]);
                }
            }
            return nge;
        }

        // Example usage / test
        public static void main(String[] args) {
            int[] arr = {5, 7, 1, 2, 6};
            int[] ans = nextGreaterElements(arr);

            System.out.println("Next greater elements in circular array:");
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

}
