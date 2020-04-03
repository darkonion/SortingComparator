package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class BucketSort implements SortingStrategy {

    @Override
    public int[] sort(int[] numbers) {

        int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

        if (numbsToSort.length <= 1) {
            System.out.println("WARN: There is nothing to sort!!! \n");
            return numbsToSort;
        }

        int largest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        //looking for min and max value
        for (int i : numbsToSort) {
            if (i >largest) {
                largest = i;
            }
            if (i < lowest) {
                lowest = i;
            }
        }

        boolean negatives = false;

        if (lowest < 0) {
            negatives = true;
        }

        // if we have negative integers, adding the lowest (abs) one to every record in array, to eliminate negatives
        if  (negatives) {
            lowest = Math.abs(lowest);
            for (int i = 0; i < numbsToSort.length; i++) {
                numbsToSort[i] += lowest;
            }
            largest += lowest;
        }

        //creating our helper array - bucket array
        int[] buckets = new int[largest + 1];

        //populating helper array
        for (int i : numbsToSort) {
            buckets[i] = buckets[i] + 1;
        }

        //finally printing sorted array, and decreasing by abs value of lowest, to retrieve original numbers

        for (int i = 0, j = 0; i < buckets.length; i++) {
                for (int m = 0; m < buckets[i]; m++) {
                    numbsToSort[j] = i;

                    if (negatives) {
                        numbsToSort[j] -= lowest;
                    }

                    j++;
                }
        }

        return numbsToSort;
    }

}
