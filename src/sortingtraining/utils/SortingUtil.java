package sortingtraining.utils;

import sortingtraining.Strategy;
import sortingtraining.decorators.SortingTimeDecorator;
import sortingtraining.sortalgorythms.SortingStrategy;

import java.util.Arrays;

public class SortingUtil {

    private final SortingStrategy sortingStrategy;

    public SortingUtil(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public int [] sort(int[] numbers, Strategy strategy) {

        SortingStrategy sortingStrategy = getResolve(strategy);
        int[] sorted = sortingStrategy.sort(numbers);
        System.out.println(Arrays.toString(sorted) + "\n");

        return sorted;
    }

    private SortingStrategy getResolve(Strategy strategy) {
        return new SortingTimeDecorator(sortingStrategy);
    }
}
