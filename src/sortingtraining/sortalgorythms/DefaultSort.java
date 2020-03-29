package sortingtraining.sortalgorythms;

import java.util.Arrays;

public class DefaultSort implements SortingStrategy {

    @Override
    public int[] sort(int[] numbers) {

        int[] numbsToSort = Arrays.copyOf(numbers, numbers.length);

        if (numbsToSort.length <= 1) {
            System.out.println("There is nothing to sort!!! \n");
            return numbsToSort;
        }

        Arrays.sort(numbsToSort, 0, numbsToSort.length-1);

        return numbsToSort;

    }
}
