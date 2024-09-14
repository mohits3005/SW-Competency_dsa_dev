package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class common_in_three_arr {

    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here

        int n1 = arr1.size();
        int n2 = arr2.size();
        int n3 = arr3.size();

        int i = 0;
        int j = 0;
        int k = 0;
        int min = Integer.MIN_VALUE;
        List<Integer> op = new ArrayList<Integer>(n1);

        while (i <n1 && j<n2 && k < n3)
        {
            if ( (arr1.get(i) == arr2.get(j)) && (arr2.get(j) == arr3.get(k))) {
                op.add(arr1.get(i));
                i++; j++; k++;

            } else {

                int temp_min = Math.min( Math.min(arr1.get(i), arr2.get(j)) , arr3.get(k));

                if (temp_min == arr1.get(i)) {
                    i++;
                }

                if (temp_min == arr2.get(j)) {
                    j++;
                }

                if (temp_min == arr3.get(k)) {
                    k++;
                }
            }



        }

        return op;

    }
}
