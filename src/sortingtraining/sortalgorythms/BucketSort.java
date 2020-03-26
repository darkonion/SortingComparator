package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class BucketSort implements SortingStrategy {

    @Override
    public int[] sort(int[] numbers) {

        int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

        int largest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        //looking for min and max value
        for (int n : numbsToSort) {
            if (n >largest) {
                largest = n;
            }
            if (n < lowest) {
                lowest = n;
            }
        }

        // if we have negative integers, adding the lowest (abs) one to every record in array, to eliminate negatives
        if  (lowest < 0) {
            lowest = Math.abs(lowest);
            for (int n = 0; n < numbsToSort.length; n++) {
                numbsToSort[n] += lowest;
            }
            largest += lowest;

        }

        //creating our helper array - bucket array
        int[] buckets = new int[largest + 1];

        //populating helper array
        for (int n : numbsToSort) {
            buckets[n] = buckets[n] + 1;
        }

        //finally printing sorted array, and decreasing by abs value of lowest, to retrieve original numbers
        int i = 0;
        for (int n = 0; n < buckets.length; n++) {
                for (int j = 0; j < buckets[n]; j++) {
                    numbsToSort[i] = n - lowest;
                    i++;
                }
        }

        return numbsToSort;
    }

}
