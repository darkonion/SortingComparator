package sortingtraining.utils;

import sortingtraining.decorators.SortingTimeDecorator;
import sortingtraining.sortalgorythms.SortingStrategy;

import java.util.Arrays;

public class SortingUtil {

    private final SortingStrategy sortingStrategy;

    public SortingUtil(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public int [] sort(int[] numbers) {

        SortingStrategy sortingStrategy = getResolve();
        int[] sorted = sortingStrategy.sort(numbers);
        System.out.println(Arrays.toString(sorted) + "\n");

        return sorted;
    }

    private SortingStrategy getResolve() {
        return new SortingTimeDecorator(sortingStrategy);
    }
}
